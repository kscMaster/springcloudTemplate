import com.itheima.es.entity.Article;
import com.itheima.es.repositories.ArticleRepository;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.common.text.Text;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.aggregations.Aggregation;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.bucket.terms.LongTerms;
import org.elasticsearch.search.aggregations.metrics.avg.InternalAvg;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.SearchResultMapper;
import org.springframework.data.elasticsearch.core.aggregation.AggregatedPage;
import org.springframework.data.elasticsearch.core.aggregation.impl.AggregatedPageImpl;
import org.springframework.data.elasticsearch.core.query.FetchSourceFilter;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SpringDataElasticSearchTest {

    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private ElasticsearchTemplate template;

    @Test
    public void createIndex() throws Exception {
        //创建索引，并配置映射关系
        template.createIndex(Article.class);
        //配置映射关系
        //template.putMapping(Article.class);
    }

    @Test
    public void addDocument() throws Exception {
        for (int i = 10; i <= 20; i++) {
            //创建一个Article对象
            Article article = new Article();
            article.setId(i);
            article.setTitle("【图解】习近平寄语中俄青少年" + i);
            article.setContent("盛会再携手—各国政要高度评价东博会和商务与投资峰会");
            //把文档写入索引库
            articleRepository.save(article);

        }
    }
    @Test
    public void deleteDocumentById() throws Exception {
        articleRepository.deleteById(1l);
        //全部删除
        //articleRepository.deleteAll();
    }

    @Test
    public void findAll() throws Exception {
        Iterable<Article> articles = articleRepository.findAll(Sort.by(Sort.Direction.DESC,"create_time"));
        articles.forEach(a-> System.out.println(a));
        articles.forEach(System.out::println);
    }
    @Test
    public void testFindById() throws Exception {
        Optional<Article> optional = articleRepository.findById(1l);
        Article article = optional.get();
        System.out.println(article);
    }

    @Test
    public void testFindByTitle() throws Exception {
        List<Article> list = articleRepository.findByTitle("maven是一个工程构建工具");
        list.stream().forEach(a-> System.out.println(a));
    }

    @Test
    public void testFindByTitleOrContent() throws Exception {
        Pageable pageable = PageRequest.of(1, 15);
        articleRepository.findByTitleOrContent("maven", "商务与投资", pageable)
                .forEach(a-> System.out.println(a));
    }

    // 根据查询构建器查询标题
    @Test
    public void testSearch(){
        MatchQueryBuilder queryBuilder = QueryBuilders.matchQuery("title", "这是文章名");
        Iterable<Article> items = this.articleRepository.search(queryBuilder);
        items.forEach(System.out::println);
    }

    // 自定义查询
    @Test
    public void testNativeSearchQuery() throws Exception {
        // 构建一个自定义构建器
//        NativeSearchQuery query = new NativeSearchQueryBuilder()
//                .withQuery(QueryBuilders.queryStringQuery("maven是一个工程构建工具").defaultField("title"))
//                .withPageable(PageRequest.of(0, 15))
//                .build();
        NativeSearchQueryBuilder query = new NativeSearchQueryBuilder();
        // 根据标题为手机的查询
        query.withQuery(QueryBuilders.matchQuery("title","手机"));
        // 添加分页
        query.withPageable(PageRequest.of(1,2));
        // 降序排列
        query.withSort(SortBuilders.fieldSort("price").order(SortOrder.DESC));

        //执行查询
        Page<Article> articles = this.articleRepository.search(query.build());
        System.out.println("articles总页数 = " + articles.getTotalPages());
        System.out.println("articles总条数 = " + articles.getTotalElements());
        articles.getContent().forEach(System.out::println);
        List<Article> articleList = template.queryForList(query.build(), Article.class);
        articleList.forEach(a-> System.out.println(a));
    }

    // 聚合查询,bucket桶（分组）
    @Test
    public void testAggsQuery() throws Exception {
        // 构建一个自定义构建器
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        // 构造器条件
        queryBuilder.addAggregation(AggregationBuilders.terms("createTimeAgg").field("createTime"));
        // 添加结果集过滤，不包含任何字段
        queryBuilder.withSourceFilter(new FetchSourceFilter(new String[]{}, null));
        // 执行聚合查询
        AggregatedPage<Article> articleAggregatedPage =
                (AggregatedPage<Article>) this.articleRepository.search(queryBuilder.build());
        // 解析聚合结果集，根据聚合的类型及字段类型进行强转，createTime是日期类型，觉和类型是词条聚合，通过createTimeAgg聚合名称获取聚合对象
        LongTerms longAggs = (LongTerms) articleAggregatedPage.getAggregation("createTimeAgg");
        List<LongTerms.Bucket> buckets = longAggs.getBuckets();
        buckets.forEach(bucket -> {
            System.out.println("bucketKey = " + bucket.getKeyAsString());
            System.out.println("bucketCount = " + bucket.getDocCount());
        });
    }

    // 聚合查询,bucket桶（分组）内嵌度量
    @Test
    public void testAggsMetricsQuery() throws Exception {
        // 构建一个自定义构建器
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        // 构造器条件，添加一个日期的搜索分组，随后再内嵌一个度量，该度量为平均值
        queryBuilder.addAggregation(AggregationBuilders.terms("createTimeAgg").field("createTime")
            .subAggregation(AggregationBuilders.avg("price_avg").field("price")));
        // 添加结果集过滤，不包含任何字段
        queryBuilder.withSourceFilter(new FetchSourceFilter(new String[]{}, null));
        // 执行聚合查询
        AggregatedPage<Article> articleAggregatedPage =
                (AggregatedPage<Article>) this.articleRepository.search(queryBuilder.build());


        // 解析聚合结果集，根据聚合的类型及字段类型进行强转，createTime是日期类型，觉和类型是词条聚合，通过createTimeAgg聚合名称获取聚合对象
        LongTerms longAggs = (LongTerms) articleAggregatedPage.getAggregation("createTimeAgg");
        List<LongTerms.Bucket> buckets = longAggs.getBuckets();
        buckets.forEach(bucket -> {
            System.out.println("bucketKey = " + bucket.getKeyAsString());
            System.out.println("bucketCount = " + bucket.getDocCount());

            Map<String, Aggregation> stringAggregationMap = bucket.getAggregations().asMap();
            InternalAvg priceAvg = (InternalAvg) stringAggregationMap.get("price_avg");
            System.out.println("平均值为"+priceAvg.getValue());
        });
    }
}
