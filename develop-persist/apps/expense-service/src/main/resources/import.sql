
insert into Associate (id, name)
 values (1, 'Jaime');
insert into Associate (id, name)
 values (2, 'Pablo');


insert into Expense (uuid, id, name, paymentmethod, amount, associate_id)
 values (random_uuid(), nextval('hibernate_sequence'), 'Desk', '0','150.50', 1);
 
insert into Expense (uuid, id, name, paymentmethod, amount, associate_id)
 values (random_uuid(), nextval('hibernate_sequence'), 'Online Learning', '1','75.00', 1);

insert into Expense (uuid, id, name, paymentmethod, amount, associate_id)
 values (random_uuid(), nextval('hibernate_sequence'), 'Books', '0','50.00', 1);

insert into Expense (uuid, id, name, paymentmethod, amount, associate_id)
 values (random_uuid(), nextval('hibernate_sequence'), 'Internet', '1','20.00', 1);

insert into Expense (uuid, id, name, paymentmethod, amount, associate_id)
 values (random_uuid(), nextval('hibernate_sequence'), 'Phone', '0','15.00', 1);

 insert into Expense (uuid, id, name, paymentmethod, amount, associate_id)
 values (random_uuid(), nextval('hibernate_sequence'), 'Bookshelf', '0','150.50', 1);

insert into Expense (uuid, id, name, paymentmethod, amount, associate_id)
 values (random_uuid(), nextval('hibernate_sequence'), 'Printer Cartridges', '1','15.00', 2);

insert into Expense (uuid, id, name, paymentmethod, amount, associate_id)
 values (random_uuid(), nextval('hibernate_sequence'), 'Online Learning', '0','50.00', 2);

insert into Expense (uuid, id, name, paymentmethod, amount, associate_id)
 values (random_uuid(), nextval('hibernate_sequence'), 'Internet', '1','20.00', 2);

insert into Expense (uuid, id, name, paymentmethod, amount, associate_id)
 values (random_uuid(), nextval('hibernate_sequence'), 'Phone', '0','15.00', 2);
