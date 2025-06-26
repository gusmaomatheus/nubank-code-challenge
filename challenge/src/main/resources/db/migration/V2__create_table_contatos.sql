CREATE TABLE IF NOT EXISTS contatos (
    id SERIAL PRIMARY KEY,
    email TEXT UNIQUE NOT NULL,
    telefone TEXT UNIQUE NOT NULL,
    id_cliente INTEGER NOT NULL,
    FOREIGN KEY (id_cliente) REFERENCES clientes(id)
);