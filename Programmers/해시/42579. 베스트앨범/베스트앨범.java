import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;


class Song {
    int index;
    int play;
    
    Song(int index, int play) {
        this.index = index;
        this.play = play;
    }
}

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> totalPlays = new HashMap<>();
        Map<String, List<Song>> songByGenres = new HashMap<>();
        
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            
            totalPlays.put(genre,
                          totalPlays.getOrDefault(genre, 0) + plays[i]);
            
            songByGenres.computeIfAbsent(
                genre,
                key -> new ArrayList<>()
            ).add(new Song(i, plays[i]));
            
        }
        
        List<String> sortedGenres  = new ArrayList<>(totalPlays.keySet());
        
        sortedGenres.sort(
            (a, b) -> Integer.compare(
                totalPlays.get(b),
                totalPlays.get(a)
            )
        );
        
        List<Integer> answer = new ArrayList<>();
        
        for (String genre : sortedGenres) {
            
            List<Song> songs = songByGenres.get(genre);
            
            songs.sort((a, b) -> {
                if (a.play != b.play) {
                    return Integer.compare(b.play, a.play);
                }
                
                return Integer.compare(a.index, b.index);
            });
            
            answer.add(songs.get(0).index);
            
            if (songs.size() >= 2) {
                answer.add(songs.get(1).index);
            }
        }
        
        return answer.stream()
            .mapToInt(Integer::intValue)
            .toArray();
        
    }
}