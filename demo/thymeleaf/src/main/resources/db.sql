CREATE TABLE `api_user` (
                            `id` bigint NOT NULL AUTO_INCREMENT,
                            `user_name` varchar(20) COLLATE utf8mb4_general_ci DEFAULT NULL,
                            `password` varchar(20) COLLATE utf8mb4_general_ci DEFAULT NULL,
                            `name` varchar(20) COLLATE utf8mb4_general_ci DEFAULT NULL,
                            `age` tinyint(1) DEFAULT NULL,
                            `gender` tinyint(1) DEFAULT NULL,
                            `birthday` datetime DEFAULT NULL,
                            `created` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
                            `updated` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
                            PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC;