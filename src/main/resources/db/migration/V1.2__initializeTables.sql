CREATE TABLE client (
	id BIGINT NOT NULL AUTO_INCREMENT,
    name_client VARCHAR(60) NOT NULL,
    email VARCHAR(255) NOT NULL,
    phone VARCHAR(20) NOT NULL,
    
    PRIMARY KEY (id)
    
);