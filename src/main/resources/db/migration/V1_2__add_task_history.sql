create table if not exists task_history (
  id serial primary key ,
  task varchar(1024) not null
  );