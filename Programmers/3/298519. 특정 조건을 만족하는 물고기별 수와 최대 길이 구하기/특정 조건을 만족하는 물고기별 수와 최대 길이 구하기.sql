-- 코드를 작성해주세요
SELECT 
    COUNT(*) AS fish_count,
    MAX(length) AS max_length,
    fish_type
FROM fish_info
GROUP BY fish_type
    HAVING (
        AVG(
            CASE 
                WHEN length IS NULL THEN 10
            ELSE length
            END
        ) >= 33
    )
ORDER BY fish_type ASC;
