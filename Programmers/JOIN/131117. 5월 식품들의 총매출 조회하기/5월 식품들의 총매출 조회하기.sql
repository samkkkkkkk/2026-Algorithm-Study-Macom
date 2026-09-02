-- 코드를 입력하세요
SELECT
    p.product_id,
    p.product_name,
    p.price * o.amount AS total_sales
FROM food_product p
JOIN
    (
        SELECT 
            product_id,
            SUM(amount) AS amount
        FROM food_order
        WHERE produce_date >= '2022-05-01'
            AND produce_date <= '2022-05-31'
        GROUP BY product_id
    ) o
    ON p.product_id = o.product_id
ORDER BY total_sales DESC, p.product_id ASC;