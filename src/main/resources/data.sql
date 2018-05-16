insert into course(id, name, created_date, last_updated_date) values (1001, 'ECO101', sysdate(), sysdate());

insert into course(id, name, created_date, last_updated_date) values (1002, 'PHY101', sysdate(), sysdate());

insert into course(id, name, created_date, last_updated_date) values (1003, 'CSE101', sysdate(), sysdate());

insert into course(id, name, created_date, last_updated_date) values (1004, 'ENG101', sysdate(), sysdate());



insert into passport(id, number) values (4001, 'E56455');

insert into passport(id, number) values (4002, 'H89554');

insert into passport(id, number) values (4003, 'S56889');



insert into student(id, name, passport_id) values (2001, 'Shoron', 4001);

insert into student(id, name, passport_id) values (2002, 'Hasan', 4002);

insert into student(id, name, passport_id) values (2003, 'Shaekh', 4003);



insert into review(id, rating, description, course_id) values (5001, '5', 'Great', 1001);

insert into review(id, rating, description, course_id) values (5002, '4', 'Good', 1001);

insert into review(id, rating, description, course_id) values (5003, '2', 'Not Good', 1003);


insert into student_course(student_id, course_id) values (2001, 1001);

insert into student_course(student_id, course_id) values (2002, 1001);

insert into student_course(student_id, course_id) values (2003, 1001);

insert into student_course(student_id, course_id) values (2001, 1003);


