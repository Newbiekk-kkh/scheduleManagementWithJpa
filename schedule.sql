create table user
(
    created_at  datetime(6)  null,
    id          bigint       auto_increment primary key,
    modified_at datetime(6)  null,
    email       varchar(255) not null,
    password    varchar(255) not null,
    username    varchar(255) not null,
    constraint UKob8kqyqqgmefl0aco34akdtpe
        unique (email)
);

create table schedule
(
    created_at  datetime(6)  null,
    id          bigint       auto_increment primary key,
    modified_at datetime(6)  null,
    user_id     bigint       null,
    contents    longtext     null,
    title       varchar(255) not null,
    constraint FKa50n59y1j4a6qwa42p8jiguds
        foreign key (user_id) references user (id)
);

create table comment
(
    created_at   datetime(6)    null,
    id           bigint         auto_increment primary key,
    modified_at  datetime(6)    null,
    schedule_id  bigint         null,
    user_id      bigint         null,
    comment_text varchar(255)   not null,
    constraint FK8kcum44fvpupyw6f5baccx25c
        foreign key (user_id)   references user (id),
    constraint FKsy51iks4dgapu66gfj3mnykch
        foreign key (schedule_id) references schedule (id)
);

