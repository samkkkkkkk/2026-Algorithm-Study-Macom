-- 코드를 입력하세요
SELECT
    food_type,
    rest_id,
    rest_name,
    favorites
FROM 
    (
        SELECT
            *,
            RANK() OVER(
                PARTITION BY food_type
                ORDER BY favorites DESC
            ) AS ranking
        FROM rest_info
    )t
WHERE ranking = 1
ORDER BY food_type DESC;