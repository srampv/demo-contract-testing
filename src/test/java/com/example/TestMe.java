package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TestMe {
    public static void main(String[] args) {
        char ch[] = "ABCD".toCharArray();
//        permute("ABCDEFGHIJKLMNOPQRSTUVWXYZ", 0, "ABCDEFGHIJKLMNOPQRSTUVWXYZ".length() - 1);
        System.out.println(squareRoot(5));
        getHouseVoted();
        Knight k = new Knight();
        Rook r = new Rook();
        Bishop b = new Bishop();
        Queen q = new Queen();
        System.out.println(k.getMoves("a8"));
        System.out.println(r.getMoves("d4"));
        System.out.println(b.getMoves("d4"));
        System.out.println(q.getMoves("d4"));
    }

    static class ChessUtil {
        public static int getIntValue(String c) {
            switch (c) {
                case "a":
                    return 1;
                case "b":
                    return 2;
                case "c":
                    return 3;
                case "d":
                    return 4;
                case "e":
                    return 5;
                case "f":
                    return 6;
                case "g":
                    return 7;
                case "h":
                    return 8;
            }
            return -1;
        }

        public static String getCharValue(int c) {
            switch (c) {
                case 1:
                    return "a";
                case 2:
                    return "b";
                case 3:
                    return "c";
                case 4:
                    return "d";
                case 5:
                    return "e";
                case 6:
                    return "f";
                case 7:
                    return "g";
                case 8:
                    return "h";
            }
            return "";
        }
    }

    private static class Knight {


        public List<String> getMoves(String position) {
            List<String> moves = new ArrayList<>();
            char c[] = position.toLowerCase().toCharArray();
            int val1 = ChessUtil.getIntValue(c[0] + "".trim());
            int val2 = Integer.parseInt(c[1] + "".trim());
            System.out.println("MOVE1:-->" + ChessUtil.getCharValue(val1 + 1) + (val2 + 2) + "".trim());
            System.out.println("MOVE2:-->" + ChessUtil.getCharValue(val1 - 1) + (val2 + 2) + "".trim());
            System.out.println("MOVE3:-->" + ChessUtil.getCharValue(val1 + 1) + (val2 - 2) + "".trim());
            System.out.println("MOVE4:-->" + ChessUtil.getCharValue(val1 - 1) + (val2 - 2) + "".trim());

            System.out.println("MOVE5:-->" + ChessUtil.getCharValue(val1 + 2) + (val2 + 1) + "".trim());
            System.out.println("MOVE6:-->" + ChessUtil.getCharValue(val1 - 2) + (val2 + 1) + "".trim());
            System.out.println("MOVE7:-->" + ChessUtil.getCharValue(val1 + 2) + (val2 - 1) + "".trim());
            System.out.println("MOVE8:-->" + ChessUtil.getCharValue(val1 - 2) + (val2 - 1) + "".trim());

            moves.add(ChessUtil.getCharValue(val1 + 1) + (val2 + 2));
            moves.add(ChessUtil.getCharValue(val1 - 1) + (val2 + 2));
            moves.add(ChessUtil.getCharValue(val1 + 1) + (val2 - 2));
            moves.add(ChessUtil.getCharValue(val1 - 1) + (val2 - 2));

            moves.add(ChessUtil.getCharValue(val1 + 2) + (val2 + 1));
            moves.add(ChessUtil.getCharValue(val1 - 2) + (val2 + 1));
            moves.add(ChessUtil.getCharValue(val1 + 2) + (val2 - 1));
            moves.add(ChessUtil.getCharValue(val1 - 2) + (val2 - 1));
            moves.add(position);

            return moves.stream().filter(p -> p.trim().length() == 2 && !p.contains("0") && !p.contains("-1") && !p.contains("9")).collect(Collectors.toList());
        }


    }

    private static class Bishop {


        public Set<String> getMoves(String position) {
            List<String> moves = new ArrayList<>();
            char c[] = position.toLowerCase().toCharArray();
            int val1 = ChessUtil.getIntValue(c[0] + "".trim());
            int val2 = Integer.parseInt(c[1] + "".trim());
            for (int i = 1; i < val1; i++, val2++) {
                System.out.println("MOVE:-->" + ChessUtil.getCharValue(i) + (val2) + "".trim());
                moves.add(ChessUtil.getCharValue(i) + (val2) + "".trim());
            }
            for (int i = val1; i <= 8; i++, val2++) {
                System.out.println("MOVE:-->" + ChessUtil.getCharValue(i) + (val2) + "".trim());
                moves.add(ChessUtil.getCharValue(i) + (val2) + "".trim());
            }

            for (int i = 1; i < val2; i++, val2--) {
                System.out.println("MOVE:-->" + ChessUtil.getCharValue(i) + (val2) + "".trim());
                moves.add(ChessUtil.getCharValue(i) + (val2) + "".trim());
            }
            for (int i = val2; i <= 8; i++, val2--) {
                System.out.println("MOVE:-->" + ChessUtil.getCharValue(i) + (val2) + "".trim());
                moves.add(ChessUtil.getCharValue(i) + (val2) + "".trim());
            }


            return moves.stream().filter(p -> p.trim().length() == 2 && !p.contains("0") && !p.contains("-1") && !p.contains("9")).collect(Collectors.toSet());
        }


    }

    private static class Queen {


        public Set<String> getMoves(String position) {
            List<String> moves = new ArrayList<>();
            char c[] = position.toLowerCase().toCharArray();
            int val1 = ChessUtil.getIntValue(c[0] + "".trim());
            int val2 = Integer.parseInt(c[1] + "".trim());
            for (int i = 1; i < val1; i++, val2++) {
                System.out.println("MOVE:-->" + ChessUtil.getCharValue(i) + (val2) + "".trim());
                moves.add(ChessUtil.getCharValue(i) + (val2) + "".trim());
            }
            for (int i = val1; i <= 8; i++, val2++) {
                System.out.println("MOVE:-->" + ChessUtil.getCharValue(i) + (val2) + "".trim());
                moves.add(ChessUtil.getCharValue(i) + (val2) + "".trim());
            }

            for (int i = 1; i < val2; i++, val2--) {
                System.out.println("MOVE:-->" + ChessUtil.getCharValue(i) + (val2) + "".trim());
                moves.add(ChessUtil.getCharValue(i) + (val2) + "".trim());
            }
            for (int i = val2; i <= 8; i++, val2--) {
                System.out.println("MOVE:-->" + ChessUtil.getCharValue(i) + (val2) + "".trim());
                moves.add(ChessUtil.getCharValue(i) + (val2) + "".trim());
            }

            for (int i = 1; i < val1; i++) {
                System.out.println("MOVE:-->" + ChessUtil.getCharValue(i) + (val2) + "".trim());
                moves.add(ChessUtil.getCharValue(i) + (val2) + "".trim());
            }
            for (int i = val1; i <= 8; i++) {
                System.out.println("MOVE:-->" + ChessUtil.getCharValue(i) + (val2) + "".trim());
                moves.add(ChessUtil.getCharValue(i) + (val2) + "".trim());
            }

            for (int i = 1; i < val2; i++) {
                System.out.println("MOVE:-->" + ChessUtil.getCharValue(val1) + (i) + "".trim());
                moves.add(ChessUtil.getCharValue(val1) + (i) + "".trim());
            }
            for (int i = val2; i <= 8; i++) {
                System.out.println("MOVE:-->" + ChessUtil.getCharValue(val1) + (i) + "".trim());
                moves.add(ChessUtil.getCharValue(val1) + (i) + "".trim());
            }


            return moves.stream().filter(p -> p.trim().length() == 2 && !p.contains("0") && !p.contains("-1") && !p.contains("9")).collect(Collectors.toSet());
        }


    }

    private static class Rook {


        public Set<String> getMoves(String position) {
            List<String> moves = new ArrayList<>();
            char c[] = position.toLowerCase().toCharArray();
            int val1 = ChessUtil.getIntValue(c[0] + "".trim());
            int val2 = Integer.parseInt(c[1] + "".trim());
            for (int i = 1; i < val1; i++) {
                System.out.println("MOVE:-->" + ChessUtil.getCharValue(i) + (val2) + "".trim());
                moves.add(ChessUtil.getCharValue(i) + (val2) + "".trim());
            }
            for (int i = val1; i <= 8; i++) {
                System.out.println("MOVE:-->" + ChessUtil.getCharValue(i) + (val2) + "".trim());
                moves.add(ChessUtil.getCharValue(i) + (val2) + "".trim());
            }

            for (int i = 1; i < val2; i++) {
                System.out.println("MOVE:-->" + ChessUtil.getCharValue(val1) + (i) + "".trim());
                moves.add(ChessUtil.getCharValue(val1) + (i) + "".trim());
            }
            for (int i = val2; i <= 8; i++) {
                System.out.println("MOVE:-->" + ChessUtil.getCharValue(val1) + (i) + "".trim());
                moves.add(ChessUtil.getCharValue(val1) + (i) + "".trim());
            }


            return moves.stream().filter(p -> p.trim().length() == 2 && !p.contains("0") && !p.contains("-1") && !p.contains("9")).collect(Collectors.toSet());
        }


    }

    private static void permute(String str, int l, int r) {
        if (l == r)
            System.out.println(str);
        else {
            for (int i = l; i <= r; i++) {
                str = swap(str, l, i);
                permute(str, l + 1, r);
                str = swap(str, l, i);
            }
        }
    }

    public static String swap(String a, int i, int j) {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }

    public static double squareRoot(int number) {
        double s = number / 2;
        double t;
        do {
            t = s;
            s = (t + (number / t)) / 2;
        } while ((t - s) != 0);
        return s;
    }

    public static String getHouseVoted() {
        Integer votes[] = {1, 2, 3, 3, 5, 5, 4, 6, 1, 1, 8, 8, 4, 4, 4};
        int votersMoney[] = {11, 22, 32, 32, 52, 52, 42, 62, 12, 12, 82, 82, 42, 42, 42};
        int houseRates[] = {100, 200, 400, 300, 200, 500, 700, 800, 900, 1000, 200, 300, 400};
        List<Employee> list = new ArrayList<>();
        List<BlogPost> listBlogs = new ArrayList<>();
        listBlogs.add(new BlogPost("test", "Venkata", BlogPostType.GUIDE, 12));
        listBlogs.add(new BlogPost("komarthy", "Ram", BlogPostType.NEWS, 11));
        listBlogs.add(new BlogPost("vantalu", "Sita", BlogPostType.NEWS, 22));
        listBlogs.add(new BlogPost("visheshalu", "Laxman", BlogPostType.REVIEW, 12));
        listBlogs.add(new BlogPost("vakyamulu", "George", BlogPostType.NEWS, 12));
        listBlogs.add(new BlogPost("technology", "Mukesh", BlogPostType.GUIDE, 421));
        listBlogs.add(new BlogPost("tourism", "Parvathi", BlogPostType.GUIDE, 123));
        listBlogs.add(new BlogPost("information", "Bob", BlogPostType.REVIEW, 122));
        listBlogs.add(new BlogPost("ideology", "Bush", BlogPostType.REVIEW, 112));
        listBlogs.add(new BlogPost("affiliction", "Palliod", BlogPostType.GUIDE, 120));
        listBlogs.add(new BlogPost("amplication", "Parvathan", BlogPostType.GUIDE, 112));
        listBlogs.add(new BlogPost("charlette", "Pankaj", BlogPostType.NEWS, 212));
        listBlogs.add(new BlogPost("carolina", "Pusti", BlogPostType.GUIDE, 12));
        listBlogs.add(new BlogPost("bumber", "Thusti", BlogPostType.NEWS, 312));
        listBlogs.add(new BlogPost("bluffer", "Krish", BlogPostType.GUIDE, 12));
        listBlogs.add(new BlogPost("builder", "Kasthuri", BlogPostType.NEWS, 12));
        listBlogs.add(new BlogPost("bastion", "Kalik", BlogPostType.GUIDE, 412));
        listBlogs.add(new BlogPost("budget", "Michael", BlogPostType.NEWS, 12));
        listBlogs.add(new BlogPost("economy", "Morty", BlogPostType.GUIDE, 12));
        listBlogs.add(new BlogPost("ebony", "Majnu", BlogPostType.NEWS, 512));
        listBlogs.add(new BlogPost("ammatuer", "Malibu", BlogPostType.GUIDE, 12));
        listBlogs.add(new BlogPost("astigmatism", "Milker", BlogPostType.NEWS, 612));
        listBlogs.add(new BlogPost("alleviate", "Mallet", BlogPostType.GUIDE, 12));
        listBlogs.add(new BlogPost("armagaddon", "Mampusa", BlogPostType.REVIEW, 12));
        listBlogs.add(new BlogPost("andariki", "Mrudula", BlogPostType.GUIDE, 12));
        listBlogs.add(new BlogPost("alltruth", "Keeper", BlogPostType.REVIEW, 12));
        listBlogs.add(new BlogPost("seeking", "Calmer", BlogPostType.GUIDE, 72));
        listBlogs.add(new BlogPost("technology", "Vendetta", BlogPostType.REVIEW, 42));
        listBlogs.add(new BlogPost("making", "Masthu", BlogPostType.GUIDE, 62));
        listBlogs.add(new BlogPost("mashing", "Muthu", BlogPostType.REVIEW, 32));
        listBlogs.add(new BlogPost("morphing", "Maker", BlogPostType.GUIDE, 22));
        listBlogs.add(new BlogPost("mumber", "Malisthu", BlogPostType.REVIEW, 82));
        listBlogs.add(new BlogPost("seeking", "Albany", BlogPostType.GUIDE, 92));
        listBlogs.add(new BlogPost("travel", "Anthony", BlogPostType.REVIEW, 52));
        listBlogs.add(new BlogPost("beauty", "Amit", BlogPostType.GUIDE, 42));
        listBlogs.add(new BlogPost("bests", "Alla", BlogPostType.REVIEW, 32));
        listBlogs.add(new BlogPost("broadcast", "Kumpust", BlogPostType.GUIDE, 22));

        list.add(new Employee("ABC", "UYT", 1, 3));
        list.add(new Employee("UYT", "PPP", 2, 1));
        list.add(new Employee("MXZ", "UUU", 3, 1));
        list.add(new Employee("ADF", "YYY", 4, 5));
        list.add(new Employee("YUH", "RRR", 5, 6));
        list.add(new Employee("SUP", "TTT", 6, 5));
        list.add(new Employee("AFF", "EEE", 7, 3));
        list.add(new Employee("MET", "WWW", 8, 3));
        list.add(new Employee("AFG", "QQQ", 9, 3));
        list.add(new Employee("YTR", "AAA", 10, 4));
        list.add(new Employee("MSS", "SSS", 11, 4));
        list.add(new Employee("QWA", "DDD", 12, 4));
        list.add(new Employee("AWE", "CCC", 13, 8));
        list.add(new Employee("SDF", "XXX", 14, 8));
        list.add(new Employee("GHJ", "VVV", 15, 8));
        list.add(new Employee("JKL", "BBB", 16, 1));
        list.add(new Employee("ALL", "NNN", 17, 1));
        list.add(new Employee("BULL", "MMM", 18, 1));
        list.add(new Employee("MED", "WED", 19, 2));
        list.add(new Employee("RED", "SED", 20, 2));
        list.add(new Employee("JUY", "XYZ", 21, 2));
        System.out.println(Arrays.asList(votes).stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())));
        System.out.println(list.stream().collect(Collectors.groupingBy(Employee::getMid, Collectors.counting())));
        Function<String, String> f = (x) -> {
            return x.contains("A") ? x : "";
        };
        System.out.println("Complex GroupBy :---->" + listBlogs.stream().collect(Collectors.groupingBy(p -> new Tuple(p.getType(), p.getAuthor()))));
        System.out.println("GroupBy Type to Set:---->" + listBlogs.stream().collect(Collectors.groupingBy(BlogPost::getType, Collectors.toSet())));
        System.out.println("GroupBy Type to Joining:---->" + listBlogs.stream().collect(Collectors.groupingBy(BlogPost::getType, Collectors.mapping(BlogPost::getTitle, Collectors.joining(",", "ME,", ",")))));
        System.out.println("GroupBy Author and Type:---->" + listBlogs.stream().collect(Collectors.groupingBy(BlogPost::getAuthor, Collectors.groupingBy(BlogPost::getType))));
//        System.out.println(listBlogs.stream().collect(Collectors.groupingBy(BlogPost::getType,()-> new EnumMap<>(BlogPostType.class,Collectors.toList()))));
        Function<String, String> f1 = (u) -> {
            return u.contains("Ve") ? "VE" : "";
        };
//        System.out.println("GroupBy and Mx Min:---->" + listBlogs.stream().collect(Collectors.groupingBy(BlogPost::getType, BinaryOperator.maxBy(Comparator.comparingInt(BlogPost::getLikes)))));
        return "";
    }

    static class Tuple {
        BlogPostType type;
        String author;

        public Tuple(BlogPostType type, String author) {
            this.type = type;
            this.author = author;
        }

        public BlogPostType getType() {
            return type;
        }

        public void setType(BlogPostType type) {
            this.type = type;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }
    }

    static class Employee {
        private String firstName;
        private String lastName;
        private int id;
        private int mid;

        public Employee(String firstName, String lastName, int id, int mid) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.id = id;
            this.mid = mid;
        }


        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getMid() {
            return mid;
        }

        public void setMid(int mid) {
            this.mid = mid;
        }
    }

    static class BlogPost {
        String title;
        String author;
        BlogPostType type;
        int likes;

        public BlogPost(String title, String author, BlogPostType type, int likes) {
            this.title = title;
            this.author = author;
            this.type = type;
            this.likes = likes;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public BlogPostType getType() {
            return type;
        }

        public void setType(BlogPostType type) {
            this.type = type;
        }

        public int getLikes() {
            return likes;
        }

        public void setLikes(int likes) {
            this.likes = likes;
        }
    }

    static enum BlogPostType {
        NEWS,
        REVIEW,
        GUIDE
    }
}
