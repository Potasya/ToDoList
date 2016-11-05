drop table if exists todolist;

create table todolist (
  id integer identity primary key,
  todo varchar(1000) not null,
  done boolean not null
);