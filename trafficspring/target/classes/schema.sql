CREATE TABLE Traffic (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    tmName VARCHAR(50),
    tcsName VARCHAR(100),
    trafficAmout VARCHAR(50),
    carType VARCHAR(50)
);

INSERT INTO traffic(tmName, tcsName, trafficAmout, carType) VALUES ('1시간', 'hi-pass', 100, '08');

INSERT INTO traffic(tmName, tcsName, trafficAmout, carType) VALUES ('2시간', 'hi-pass', 200, '12');