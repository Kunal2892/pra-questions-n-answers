import java.util.*;

class Movie{
    private String moviename;
    private String genre;
    private float rating;

    Movie(String moviename, String genre,  float rating)
    {
        this.moviename=moviename;
        this.genre=genre;
        this.rating=rating;
    }
    public String getmoviename(){return moviename;}
    public String getgenre(){return genre;}
    public float getrating(){return rating;}
}

public class solution3 {

public static List<Movie> fmbr(Map<Integer,List<Movie>>movieMap, float rating)
{
    List<Movie> res=new ArrayList<>();

    HashSet<Float> seenrating=new HashSet<>();

    for (Map.Entry<Integer, List<Movie>> en : movieMap.entrySet()) {
        List<Movie>movielist=en.getValue();


        for(Movie me:movielist)
        {
            if(me.getrating()==rating)
            {
                if(!seenrating.contains(me.getrating()))
                {
                    res.add(me);
                    seenrating.add(me.getrating());
                }
            }
        }

        
    }
    return res; 

}


public static float calculate_average (Map<Integer,List<Movie>>movieMap, String genre )
{
    float sum=0.0f;
    int count=0;

    for (Map.Entry<Integer, List<Movie>> en : movieMap.entrySet()) {
        List<Movie>movielist=en.getValue();

        for(Movie me:movielist)
        {
            if(me.getgenre().equalsIgnoreCase(genre))
            {
                sum+=me.getrating();
                count+=1;
            }
        }
    }
    if(count==0)
    {
        return 0.0f;
    }
    return sum/count;
}


    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();

        Map<Integer,List<Movie>>movieMap=new HashMap<>();
       // List<Movie>movies=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            int movieId=sc.nextInt();
            sc.nextLine();
            String moviename=sc.nextLine();
            String moviegenre=sc.nextLine();
            float rating=sc.nextFloat();
            Movie m= new Movie(moviename, moviegenre, rating);

             List<Movie>movies=new ArrayList<>();
            movies.add(m);
        movieMap.put(movieId, movies);

        }

        float desiredrating=sc.nextFloat();
        sc.nextLine();//();

        List<Movie>movies=fmbr(movieMap, desiredrating);
        if(!movies.isEmpty())
        {
           for (Movie ans : movies) {
    System.out.println("Movie Name: " + ans.getmoviename());
    System.out.println("Genre: " + ans.getgenre());
    System.out.printf("Rating: %.2f%n", ans.getrating());
}
        }
        else{
            System.out.println("No movie with that rating ");
        }

          String desiredgenre=sc.nextLine();//();
       // sc.nextLine();//();

        float avgr=calculate_average(movieMap, desiredgenre);

        System.out.printf("average is : %.2f%n",avgr);
        
        sc.close();
    }
}
