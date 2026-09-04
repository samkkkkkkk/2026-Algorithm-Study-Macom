-- 코드를 작성해주세요
SELECT 
    COUNT(*) AS fish_count,
    EXTRACT(MONTH FROM time)
FROM fish_info
GROUP BY EXTRACT(MONTH FROM time)
ORDER BY EXTRACT(MONTH FROM time) ASC;