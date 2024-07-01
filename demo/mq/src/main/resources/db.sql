CREATE TABLE `users` (
                         `id` bigint NOT NULL AUTO_INCREMENT,
                         `email` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
                         `password` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
                         `name` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
                         `createdAt` bigint NOT NULL,
                         PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;