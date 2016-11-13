CREATE TABLE test.todolist (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `todo` varchar(1000) NOT NULL,
  `done` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
)