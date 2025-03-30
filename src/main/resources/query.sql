create table venues (
                        venues_id serial primary key,
                        venues_name varchar(100) not null ,
                        location  varchar(100) not null
);


create table events(
                       event_id  serial primary key,
                       event_name varchar(100)  not null ,
                       event_date timestamp not null ,
                       venues_id  INTEGER REFERENCES venues(venues_id) ON DELETE CASCADE
);

create table attendee(
                         attendee_id serial primary key ,
                         attendee_name varchar(100) not null,
                         email varchar(50) not null
);

create table event_attendee(
                               id serial primary key,
                               event_id int references events(event_id) on delete cascade,
                               attendee_id int references  attendee(attendee_id) on delete cascade

);

