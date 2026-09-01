-- 코드를 작성해주세요
SELECT 
    COUNT(*) AS fish_count
FROM fish_info
WHERE TIME >= '2021/01/01'
    AND TIME < '2022/01/01';
