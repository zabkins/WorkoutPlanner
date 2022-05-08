schema_name workout_planner


create table if not exists muscle_group
(
    id   bigint auto_increment
    primary key,
    name varchar(255) null
    );

create table if not exists exercise
(
    id              bigint auto_increment
    primary key,
    description     varchar(255) null,
    name            varchar(255) null,
    muscle_group_id bigint       null,
    constraint FKmm3kvm4hikt663ona884anc1p
    foreign key (muscle_group_id) references muscle_group (id)
    );

create table if not exists training_day
(
    id   bigint auto_increment
    primary key,
    name varchar(255) null
    );

create table if not exists training_day_exercises
(
    training_day_id bigint not null,
    exercises_id    bigint not null,
    constraint FK8sp5jwq7kadqb447wiy9iyox1
    foreign key (exercises_id) references exercise (id),
    constraint FKjip0l9yrex1jlikbnqgqv7g1j
    foreign key (training_day_id) references training_day (id)
    );

create table if not exists workout_plan
(
    id     bigint auto_increment
    primary key,
    active bit          not null,
    name   varchar(255) null
    );

create table if not exists workout_plan_training_days
(
    workout_plan_id  bigint not null,
    training_days_id bigint not null,
    constraint UK_m87m23667kfsr3pa6xnnvkn4i
    unique (training_days_id),
    constraint FK6g7rtn9e3g5m0h0ialj26mj3r
    foreign key (training_days_id) references training_day (id),
    constraint FKqiwpswynqkcvw07f0bodm9p9s
    foreign key (workout_plan_id) references workout_plan (id)
    );

