-- 코드를 입력하세요
SELECT
    EXTRACT(HOUR FROM datetime) AS HOUR,
    COUNT(*) AS COUNT
FROM animal_outs
    WHERE EXTRACT(HOUR FROM datetime) >= '09'
        AND EXTRACT(HOUR FROM datetime) < '20'
GROUP BY EXTRACT(HOUR FROM datetime)
ORDER BY EXTRACT(HOUR FROM datetime) ASC;