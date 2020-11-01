create table users(id INT AUTO_INCREMENT primary key, username VARCHAR(30) unique, email varchar(30));
create table jobs(id INT AUTO_INCREMENT PRIMARY KEY, username VARCHAR(30), designation VARCHAR(30), compensation INT, location VARCHAR(30), notice_period INT, skills VARCHAR(100), foreign key (username) references users(username));

CREATE TRIGGER check_user_exists
    BEFORE INSERT
    ON jobs FOR EACH ROW
    BEGIN
	    if (select count(*) from users where username = new.username) = 0 then
	    insert into users(username) values (new.username);
	    end if;
    END;
insert into users(username, email) values ('default', 'default@default.com');
insert into jobs(username, designation, compensation, location, notice_period, skills) values ('default', 'backend developer', 1200000, 'bangalore', '45', 'backend technologies');