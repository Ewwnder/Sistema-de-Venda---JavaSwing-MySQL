CREATE TABLE Cliente(
	id_cliente int PRIMARY key AUTO_INCREMENT,
    nome_cliente VARCHAR(150) not null,
    email varchar(200) not null UNIQUE,
    telefone varchar(25) not null
);

CREATE TABLE Produto(
	id_produto int primary key AUTO_INCREMENT,
    nome_produto varchar(200) not null,
    descricao varchar(255),
    preco_venda decimal(10,2) not null,
    quantidade int check(quantidade>0)
);


CREATE TABLE Nota_Fiscal(
	id_nota_fiscal int PRIMARY KEY AUTO_INCREMENT,
    id_cliente int,
    data_emissao date not null,
    valor_total double check(valor_total>=0),
    FOREIGN KEY(id_cliente) REFERENCES Cliente(id_cliente)
);

CREATE TABLE Item_Nota_Fiscal(
    id_item_nota_fiscal int PRIMARY KEY AUTO_INCREMENT,
    id_nota_fiscal int,
    id_produto int,
    quantidade int check(quantidade>0),
    valor_unitario DECIMAL(10,2) not null,
    FOREIGN KEY(id_nota_fiscal) REFERENCES Nota_Fiscal(id_nota_fiscal),
    FOREIGN KEY(id_produto) REFERENCES Produto (id_produto)
)