-- 코드를 입력하세요
SELECT
    ingredient_type,
    SUM(h.total_order) AS total_order
FROM first_half h
JOIN icecream_info f
    ON h.flavor = f.flavor
GROUP BY f.ingredient_type
ORDER BY total_order ASC;