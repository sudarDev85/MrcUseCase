DROP TABLE IF EXISTS hotels;
 
CREATE TABLE hotels (
  hotel_id INT AUTO_INCREMENT  PRIMARY KEY,
  hotel_name VARCHAR(250) NOT NULL,
  location VARCHAR(100) NOT NULL,
  available_room INT,
  features VARCHAR(250) NOT NULL,
  price DECIMAL(10,2)
);
/*
CREATE TABLE hotel_reservations (
  hotel_reservations_id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  address_line_1 VARCHAR(200) NOT NULL,
  address_line_2 VARCHAR(200) NULL,
  city VARCHAR(100) NOT NULL,
  state VARCHAR(100) NOT NULL,
  country VARCHAR(50) NOT NULL,
  zipcode VARCHAR(50) NOT NULL,
  hotel_id INT,
);
 
ALTER TABLE hotel_reservations ADD FOREIGN KEY (hotel_id) REFERENCES hotels( hotel_id ) ; */
 
INSERT INTO hotels (hotel_name, location, available_room,features, price) VALUES
  ('Holiday Inn', 'Chennai', 100,'Housekeeping,SwimmingPool,Restaurant,Parking,Bar',1456.50);
 INSERT INTO hotels (hotel_name, location, available_room,features, price) VALUES
  ('Aria', 'Chennai', 100,'Housekeeping,SwimmingPool,Restaurant,Parking,Bar,Spa',2456.50);
 INSERT INTO hotels (hotel_name, location, available_room,features, price) VALUES
  ('Marriott', 'Chennai', 120,'Housekeeping, SwimmingPool, Restaurant, Bar, Spa',1455.54);
 INSERT INTO hotels (hotel_name, location, available_room,features, price) VALUES
  ('Days Inn', 'Chennai', 130,'Housekeeping, SwimmingPool, Parking, Bar, Spa',1453.50);
 INSERT INTO hotels (hotel_name, location, available_room,features, price) VALUES
  ('MGM', 'Chennai', 100,'Housekeeping, SwimmingPool, Restaurant, Parking, Spa',1455.50),
  ('Le Palace', 'Chennai', 100,'Housekeeping, SwimmingPool, Restaurant, Parking, Spa',1436.99);
 INSERT INTO hotels (hotel_name, location, available_room,features, price) VALUES
  ('Le Meridian', 'Chennai', 110,'Housekeeping, SwimmingPool, Restaurant, Parking, Bar, Spa',1156.99);
 INSERT INTO hotels (hotel_name, location, available_room,features, price) VALUES
  ('Hablis', 'Chennai', 100,'Housekeeping, Restaurant, Parking, Bar, Spa',2456.96);
 INSERT INTO hotels (hotel_name, location, available_room,features, price) VALUES
  ('Fab Hotel', 'Chennai', 90,'Housekeeping, SwimmingPool, Restaurant, Parking, Bar, Spa',1756.98);
 INSERT INTO hotels (hotel_name, location, available_room,features, price) VALUES
  ('Oyo 3345', 'Chennai', 10,'Housekeeping, SwimmingPool, Parking, Bar, Spa',1496.50);
 INSERT INTO hotels (hotel_name, location, available_room,features, price) VALUES
  ('Oyo 3365', 'Chennai', 30,'Housekeeping, Parking, Bar, Spa',1356.34),
  ('Oyo 3365', 'Chennai', 50,'Housekeeping, SwimmingPool, Restaurant, Bar, Spa',1856.50);
 INSERT INTO hotels (hotel_name, location, available_room,features, price) VALUES
  ('Oyo 3385', 'Chennai', 55,'Housekeeping, Restaurant, Parking, Bar, Spa',1496.26);
 INSERT INTO hotels (hotel_name, location, available_room,features, price) VALUES
  ('Ocean Spray', 'Pondicherry', 110,'Housekeeping, SwimmingPool, Restaurant, Parking, Bar, Spa',14056.55);
 INSERT INTO hotels (hotel_name, location, available_room,features, price) VALUES
  ('Accord', 'Pondicherry', 200,'Housekeeping, SwimmingPool, Restaurant, Bar, Spa',4056.56);
 INSERT INTO hotels (hotel_name, location, available_room,features, price) VALUES
  ('Le Royal park', 'Pondicherry', 40,'Housekeeping, SwimmingPool, Parking, Bar, Spa',1456.58);
 INSERT INTO hotels (hotel_name, location, available_room,features, price) VALUES
  ('Le Pondy', 'Pondicherry', 50,'Housekeeping, SwimmingPool, Restaurant, Parking, Bar, Spa',1356.59);
 INSERT INTO hotels (hotel_name, location, available_room,features, price) VALUES
  ('Olive De Villa Resort', 'Pondicherry', 55,'Housekeeping, Restaurant, Parking, Bar, Spa',1456.67);
 INSERT INTO hotels (hotel_name, location, available_room,features, price) VALUES
  ('white Pearl', 'Pondicherry', 60,'Housekeeping, SwimmingPool, Restaurant, Parking, Spa',1456.69);
 INSERT INTO hotels (hotel_name, location, available_room,features, price) VALUES
  ('Club Mahindra', 'Pondicherry', 62,'Housekeeping, SwimmingPool, Restaurant, Parking, Spa',1456.80);
 INSERT INTO hotels (hotel_name, location, available_room,features, price) VALUES
  ('Red Inn', 'Pondicherry', 70,'Housekeeping, SwimmingPool, Restaurant, Bar, Spa',1456.90);
  
  
 
      
            