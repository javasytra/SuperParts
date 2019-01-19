USE test;

DROP TABLE IF EXISTS parts;
CREATE TABLE parts
(
  id INT AUTO_INCREMENT
    PRIMARY KEY ,
  title VARCHAR(100) NULL,
  need TINYINT NULL,
  partscount INT NULL
)
  ENGINE = innoDB
  DEFAULT CHARACTER SET = utf8
;

INSERT INTO parts (title, need, partscount) VALUES ('HDD',true,10);
INSERT INTO parts (title, need, partscount) VALUES ('MotherBoard',true,3);
INSERT INTO parts (title, need, partscount) VALUES ('WIFI Router',false,2);
INSERT INTO parts (title, need, partscount) VALUES ('микрофон',false ,3);
INSERT INTO parts (title, need, partscount) VALUES ('Принтер',false,6);
INSERT INTO parts (title, need, partscount) VALUES ('CPU',true ,4);
INSERT INTO parts (title, need, partscount) VALUES ('Video Card', true,3);
INSERT INTO parts (title, need, partscount) VALUES ('Keyboard',false,5);
INSERT INTO parts (title, need, partscount) VALUES ('Mouse',false,1);
INSERT INTO parts (title, need, partscount) VALUES ('Копьютерная мышка',false ,6);
INSERT INTO parts (title, need, partscount) VALUES ('USB flash',false ,3);
INSERT INTO parts (title, need, partscount) VALUES ('Memory DDR4 2Gb',false,7);
INSERT INTO parts (title, need, partscount) VALUES ('картридер',false,12);
INSERT INTO parts (title, need, partscount) VALUES ('Термопаста',true ,7);
INSERT INTO parts (title, need, partscount) VALUES ('Video Camera',false ,4);
INSERT INTO parts (title, need, partscount) VALUES ('клавиатура',false ,7);
INSERT INTO parts (title, need, partscount) VALUES ('Sound Card',true,5);
INSERT INTO parts (title, need, partscount) VALUES ('CD-disk',false,2);
INSERT INTO parts (title, need, partscount) VALUES ('сканер',false,3);
INSERT INTO parts (title, need, partscount) VALUES ('Оптический привод',false ,7);
INSERT INTO parts (title, need, partscount) VALUES ('монитор',false ,8);
INSERT INTO parts (title, need, partscount) VALUES ('Блок питания',true,11);
