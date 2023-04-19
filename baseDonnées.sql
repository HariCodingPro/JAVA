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

CREATE TABLE Recycleur(
    id INT PRIMARY KEY,
    nom VARCHAR(30)
);

CREATE TABLE centreTri(
    id INT PRIMARY KEY,
    nom VARCHAR(30),
    adresse VARCHAR(50), --ou alors avec la longitude et la latitude ; longitude DECIMAL(13,10) NOT NULL, latitude DECIMAL(13,10) NOT NULL, --
    nmbPoubelle INT                            
);

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

CREATE TABLE Commerce(
    id INT PRIMARY KEY,
    nom VARCHAR(30),
    adresse VARCHAR(50) --ou alors avec la longitude et la latitude ; longitude DECIMAL(13,10) NOT NULL, latitude DECIMAL(13,10) NOT NULL, --
); 

CREATE TABLE Personne(
    id INT PRIMARY KEY,
    nom VARCHAR(50),
    adresse VARCHAR(50) --ou alors avec la longitude et la latitude ; longitude DECIMAL(13,10) NOT NULL, latitude DECIMAL(13,10) NOT NULL, --
    telephone VARCHAR(13) -- 13 caractères en comptant le "+33" ou autre et 10 sinon -- --2eme question; INT ou VARCHAR ? => pb de INT c est qu'il y a possiblement le 0 de devant qui ne comptera pas --
);

CREATE TABLE Compte(
    id INT PRIMARY KEY,
    idPersonne INT,
    nmbPoint INT,
    FOREIGN KEY fk_compte(idPersonne) REFERENCES Personne(id)
);

CREATE TABLE Poubelle(
    id INT PRIMARY KEY,
    typeDechet VARCHAR(20), 
    qteMax INT,
    emplacement VARCHAR(50) --ou alors avec la longitude et la latitude ; longitude DECIMAL(13,10) NOT NULL, latitude DECIMAL(13,10) NOT NULL, --
);

CREATE TABLE Depot(
    id INT PRIMARY KEY,
    dateDepot DATE,
    idPoubelle INT,
    heureDepot DATE, --On peut pas inclure l'heure dans la date juste au dessus ?--
    idMenage INT,
    -- tabDetail? --
    FOREIGN KEY fk_menage(idMenage) REFERENCES Menage(id),
    FOREIGN KEY fk_poubelle(idPoubelle) REFERENCES Poubelle(id)
);

CREATE TABLE detailDepot(
    idDepot INT,
    typeDechet VARCHAR(20),
    qte FLOAT,
    CONSTRAINT pk_detailDepot PRIMARY KEY (idDepot, typeDechet),
    FOREIGN KEY fk_depot(idDepot) REFERENCES Depot(id),
    FOREIGN KEY fk_typeDechet(typeDechet) REFERENCES Dechet(nom)
);

CREATE TABLE Dechet(
    nom VARCHAR(20) PRIMARY KEY,
    poids FLOAT,
    typePbl VARCHAR(20)
);

CREATE TABLE Menage(
    id INT PRIMARY KEY,
    nmbPersonne INT --??--
);

CREATE TABLE agentTri
CREATE TABLE Administrateur