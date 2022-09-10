CREATE TABLE IF NOT EXISTS usuario (
    id SERIAL PRIMARY KEY,
    nome TEXT NOT NULL
);

CREATE TABLE IF NOT EXISTS filme (
    id SERIAL PRIMARY KEY,
    titulo TEXT NOT NULL,
    nota INT NOT NULL,
    comentario TEXT,
    usuario_id INT,
    FOREIGN KEY (usuario_id) REFERENCES usuario (id)
);
