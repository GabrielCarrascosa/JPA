INSERT INTO clientes (cliente_id, nome, email) VALUES
(1, 'Gabriel Carrascosa', 'gabriel@example.com'),
(2, 'Ana Souza', 'ana@example.com'),
(3, 'Carlos Lima', 'carlos@example.com');

INSERT INTO pedidos (pedido_id, descricao, data, cliente_id) VALUES
(1, 'Pedido de material de escritório', '2025-11-10', 1),
(2, 'Pedido de notebooks', '2025-11-11', 1),
(3, 'Pedido de impressoras', '2025-11-09', 2),
(4, 'Pedido de cadeiras', '2025-11-12', 3);

INSERT INTO produtos (produto_id, nome, preco, pedido_id) VALUES
(1, 'Caneta', 5, 1),
(2, 'Caderno', 15, 1),
(3, 'Notebook Dell', 3500, 2),
(4, 'Notebook HP', 3200, 2),
(5, 'Impressora Epson', 1200, 3),
(6, 'Impressora HP', 1100, 3),
(7, 'Cadeira Gamer', 800, 4),
(8, 'Cadeira Escritório', 400, 4);