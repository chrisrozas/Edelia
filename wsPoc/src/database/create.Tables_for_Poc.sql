create table CLIENT (
     ID varchar(12) NOT NULL,
    NOM varchar(100),
    PRENOM varchar(100),
    EMAIL varchar(300),
    ETAT varchar(300),
    primary key (ID)
);

create table CONTRAT (
    ID varchar(64),
    NUM_ACCORD_COMMERCIAL varchar(100),
    TARIF varchar(100),
    OPTION_TARIFAIRE varchar(300),
    PUISSANCE_SOUSCRITE varchar(300),
    CATEGORIE_TPM varchar(300),
    primary key (ID)
);

create table CONTRAT (
    ID varchar(64),
    NUM_ACCORD_COMMERCIAL varchar(100),
    TARIF varchar(100),
    OPTION_TARIFAIRE varchar(300),
    PUISSANCE_SOUSCRITE varchar(300),
    CATEGORIE_TPM varchar(300),
    primary key (ID)
);

create table OFFRE (
    ID varchar(64),
    CODE_OFFRE varchar(100),
    STATUT_CONTRAT_SERVICE varchar(100),
    ID_CONTRAT_SERVICE varchar(300),
    primary key (ID)
);

create table SITE (
    PDL varchar(64),
    NUMERO_RUE varchar(100),
    CODE_POSTAL varchar(100),
    COMMUNE varchar(300),
    PAYS varchar(300),
    PHASES varchar(300),
    primary key (PDL)
);





       
