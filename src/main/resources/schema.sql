CREATE TABLE COMPLAINTS(
	complaint_number BIGINT PRIMARY KEY AUTO_INCREMENT,
	complainant_name VARCHAR(255),
	phone_number VARCHAR(20),
	complaint_location VARCHAR(255),
	issue VARCHAR(255),
	description VARCHAR(1000),
	date DATE,
	image_url VARCHAR(255)
);