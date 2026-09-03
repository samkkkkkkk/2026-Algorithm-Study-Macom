-- 코드를 입력하세요
SELECT
    EXTRACT(YEAR FROM o.sales_date) AS year,
    EXTRACT(MONTH FROM o.sales_date) AS month,
    COUNT(DISTINCT o.user_id) AS purchased_users,
    ROUND(
        COUNT(DISTINCT o.user_id) / 
        (
            SELECT 
                COUNT(*) 
            FROM user_info 
            WHERE joined >= '2021-01-01'
                AND joined < '2022-01-01'
        ),
        1
    ) AS purchased_ratio
FROM online_sale o
JOIN user_info i
    ON o.user_id = i.user_id
WHERE i.joined >= '2021-01-01'
    AND i.joined < '2022-01-01'
GROUP BY 
    EXTRACT(YEAR FROM o.sales_date),
    EXTRACT(MONTH FROM o.sales_date)
ORDER BY 
    year ASC,
    month ASC;