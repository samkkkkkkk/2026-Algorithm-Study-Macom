-- 코드를 입력하세요
SELECT
    h.flavor
FROM first_half h
JOIN
    (
        SELECT
            flavor,
            SUM(total_order) AS j_total_order
        FROM july
        GROUP BY flavor
    ) j
ON h.flavor = j.flavor
ORDER BY h.total_order + j.j_total_order DESC
LIMIT 3;