DROP DATABASE IF EXISTS Tri;
CREATE DATABASE Tri;
USE Tri;

DROP TABLE IF EXISTS Conditionneur;
DROP TABLE IF EXISTS Recycleur;
DROP TABLE IF EXISTS centreTri;
DROP TABLE IF EXISTS Contrat;
DROP TABLE IF EXISTS Commerce;
DROP TABLE IF EXISTS Personne;
DROP TABLE IF EXISTS Compte;
DROP TABLE IF EXISTS Poubelle;
DROP TABLE IF EXISTS Depot;
DROP TABLE IF EXISTS detailDepot;
DROP TABLE IF EXISTS Dechet;
DROP TABLE IF EXISTS Menage;
DROP TABLE IF EXISTS agentTri;
DROP TABLE IF EXISTS Administrateur;





CREATE TABLE Conditionneur(
    id INT PRIMARY KEY,
    nom VARCHAR(30)
);

INSERT INTO Conditionneur VALUES (1,"Conditionneur Cergy");
INSERT INTO Conditionneur VALUES (2,"Conditionneur Pontoise");





CREATE TABLE Recycleur(
    id INT PRIMARY KEY,
    nom VARCHAR(30)
);

INSERT INTO Recycleur VALUES (1,"Recycleur Cergy");
INSERT INTO Recycleur VALUES (2,"Recycleur Pontoise");





CREATE TABLE centreTri(
    id INT PRIMARY KEY,
    nom VARCHAR(30),
    adresse VARCHAR(50),
    nmbPoubelle INT                            
);

INSERT INTO centreTri VALUES (1,"Centre de Cergy", "10 Boulevard du Port 95000 Cergy", 5);
INSERT INTO centreTri VALUES (2,"Centre de Pontoise", "83 Boulevard Jacques Tête 95300 Pontoise",4);





CREATE TABLE Contrat(
    idCentreTri INT,
    idCommerce INT,
    datDebut DATE,
    dateFin DATE,
    --Produit ?--
    --reglePoint?--
    CONSTRAINT pk_contrat PRIMARY KEY (idCentreTri, idCommerce),
    FOREIGN KEY fk_centreTri(idCentreTri) REFERENCES centreTri(id),
    FOREIGN KEY fk_commerce(idCommerce) REFERENCES Commerce(id)
);

INSERT INTO Contrat VALUES (1, 1, "2022-04-24", "2024-04-24");
INSERT INTO Contrat VALUES (2, 2, "2023-02-13", "2025-02-13");





CREATE TABLE Commerce(
    id INT PRIMARY KEY,
    nom VARCHAR(30),
    adresse VARCHAR(50) 
); 

INSERT INTO Commerce VALUES (1,"Auchan","Centre commercial des 3 Fontaines, 95000 Cergy");
INSERT INTO Conditionneur VALUES (2,"Leclerc","La Croix Saint simon, 1 Chemin des Hayettes 95250 Osny");





CREATE TABLE Personne(
    id INT PRIMARY KEY,
    idMenage INT,
    nom VARCHAR(50),
    adresse VARCHAR(50), 
    telephone VARCHAR(13), 
    FOREIGN KEY fk_menage(idMenage) REFERENCES Menage(id)
);

INSERT INTO Personne VALUES (1,1,"Harilala","3 rue Lebon","0712654894");
INSERT INTO Personne VALUES (2,1,"Ines","3 rue Lebon","0645987325");
INSERT INTO Personne VALUES (3,1,"Benjamin R","3 rue Lebon","0746238516");
INSERT INTO Personne VALUES (4,2,"Benjamin L","3 rue Lebon","0644568891");
INSERT INTO Personne VALUES (5,2,"Paul","3 rue Lebon","0712654894");
INSERT INTO Personne VALUES (6,2,"Antonin","3 rue Lebon","0768342678");





CREATE TABLE Compte(
    id INT PRIMARY KEY,
    idMenage INT,
    nmbPoint INT,
    FOREIGN KEY fk_menage(idMenage) REFERENCES Menage(id)
);

INSERT INTO Compte VALUES (1, 1, 10);
INSERT INTO Compte VALUES (2, 2, 0);





CREATE TABLE Poubelle(
    id INT PRIMARY KEY,
    idCentreTri INT,
    typeDechet VARCHAR(20), 
    poidsMax INT,
    emplacement VARCHAR(50) 
    FOREIGN KEY fk_centreTri(idCentreTri) REFERENCES centreTri(id)
);

INSERT INTO Poubelle VALUES (1,1, "Verre", 10000, "5 Boulevard du Port 95000 Cergy");
INSERT INTO Poubelle VALUES (2,1, "Plastique", 15000, "5 Boulevard du Port 95000 Cergy");
INSERT INTO Poubelle VALUES (3,1, "Carton", 25000, "5 Boulevard du Port 95000 Cergy");
INSERT INTO Poubelle VALUES (4,1, "Metal", 20000, "5 Boulevard du Port 95000 Cergy");
INSERT INTO Poubelle VALUES (5,1, "Verre", 10000, "Centre commercial des 3 Fontaines, 95000 Cergy");
INSERT INTO Poubelle VALUES (6,2, "Verre", 10000, "16 Boulevard Jacques Tête 95300 Pontoise");
INSERT INTO Poubelle VALUES (7,2, "Plastique", 15000, "16 Boulevard Jacques Tête 95300 Pontoise");
INSERT INTO Poubelle VALUES (8,2, "Carton", 25000, "16 Boulevard Jacques Tête 95300 Pontoise");
INSERT INTO Poubelle VALUES (9,2, "Metal", 20000, "16 Boulevard Jacques Tête 95300 Pontoise");





CREATE TABLE Depot(
    id INT PRIMARY KEY,
    dateDepot DATE,
    idPoubelle INT,
    idMenage INT,
    -- tabDetail? --
    FOREIGN KEY fk_menage(idMenage) REFERENCES Menage(id),
    FOREIGN KEY fk_poubelle(idPoubelle) REFERENCES Poubelle(id)
);

INSERT INTO Depot VALUES (1,"2023-04-24",2,1);
INSERT INTO Depot VALUES (2,"2023-02-12",1,1);
INSERT INTO Depot VALUES (3,"2022-11-20",3,2);
INSERT INTO Depot VALUES (4,"2022-06-30",1,1);
INSERT INTO Depot VALUES (5,"2023-01-08",4,1);
INSERT INTO Depot VALUES (6,"2023-04-16",5,2);
INSERT INTO Depot VALUES (7,"2023-02-14",7,2);
INSERT INTO Depot VALUES (8,"2022-12-05",8,2);
INSERT INTO Depot VALUES (9,"2022-12-16",4,1);
INSERT INTO Depot VALUES (10,"2023-03-15",8,2);
INSERT INTO Depot VALUES (11,"2023-01-26",6,1);
INSERT INTO Depot VALUES (12,"2022-07-12",2,2);
INSERT INTO Depot VALUES (13,"2022-10-21",2,1);
INSERT INTO Depot VALUES (14,"2022-09-12",4,2);
INSERT INTO Depot VALUES (15,"2023-01-26",9,2);
INSERT INTO Depot VALUES (16,"2023-03-10",1,1);
INSERT INTO Depot VALUES (17,"2022-05-14",5,1);
INSERT INTO Depot VALUES (18,"2022-11-13",6,2);
INSERT INTO Depot VALUES (19,"2023-02-26",8,1);
INSERT INTO Depot VALUES (20,"2023-04-15",8,1);





CREATE TABLE detailDepot(
    idDepot INT,
    typeDechet VARCHAR(20),
    qte FLOAT,
    CONSTRAINT pk_detailDepot PRIMARY KEY (idDepot, typeDechet),
    FOREIGN KEY fk_depot(idDepot) REFERENCES Depot(id),
    FOREIGN KEY fk_typeDechet(typeDechet) REFERENCES Dechet(nom)
);

INSERT INTO detailDepot VALUES (1,"Plastique", 35);
INSERT INTO detailDepot VALUES (2,"Verre", 16);
INSERT INTO detailDepot VALUES (3,"Carton", 10);
INSERT INTO detailDepot VALUES (4,"Verre", 15);
INSERT INTO detailDepot VALUES (5,"Metal", 10);
INSERT INTO detailDepot VALUES (6,"Verre", 25);
INSERT INTO detailDepot VALUES (7,"Plastique", 25);
INSERT INTO detailDepot VALUES (8,"Carton", 20);
INSERT INTO detailDepot VALUES (9,"Metal", 15);
INSERT INTO detailDepot VALUES (10,"Carton", 30);
INSERT INTO detailDepot VALUES (11,"Verre", 10);
INSERT INTO detailDepot VALUES (12,"Plastique", 30);
INSERT INTO detailDepot VALUES (13,"Plastique", 35);
INSERT INTO detailDepot VALUES (14,"Metal", 20);
INSERT INTO detailDepot VALUES (15,"Metal", 17);
INSERT INTO detailDepot VALUES (16,"Verre", 5);
INSERT INTO detailDepot VALUES (17,"Verre", 10);
INSERT INTO detailDepot VALUES (18,"Verre", 20);
INSERT INTO detailDepot VALUES (19,"Carton", 25);
INSERT INTO detailDepot VALUES (20,"Carton", 15);





CREATE TABLE Dechet(
    nom VARCHAR(20) PRIMARY KEY,
    poids FLOAT,
    typePbl VARCHAR(20)
);

INSERT INTO Dechet VALUES ("Verre", 40 ,"Verte");
INSERT INTO Dechet VALUES ("Plastique", 30 ,"Jaune");
INSERT INTO Dechet VALUES ("Carton", 20 ,"Jaune");
INSERT INTO Dechet VALUES ("Metal", 50 ,"Grise");





CREATE TABLE Menage(
    id INT PRIMARY KEY,
    nmbPersonne INT
);

INSERT INTO Menage VALUES (1, 6);





CREATE TABLE agentTri(
    id INT PRIMARY KEY,
    nom VARCHAR(30)
);

INSERT INTO agentTri VALUES (1,"nomAgent1");





CREATE TABLE Administrateur(
    id INT PRIMARY KEY,
    nom VARCHAR(30)
);

INSERT INTO Administrateur VALUES (1, "nomAdmin1");
