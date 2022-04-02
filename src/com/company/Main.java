package com.company;


public class Main {

    public static void main(String[] args) {
        StringList myFriends = new StringListImpl();
        myFriends.add("Саша");
        myFriends.add("Петя");
        String friend1 = myFriends.add("Вася");
        System.out.println(friend1);
        myFriends.add("Максим");
        System.out.println(myFriends.size());
        String friend2 = myFriends.add(0, "Катя");
        System.out.println(friend2);
        System.out.println(myFriends.size());
        myFriends.add(2, "Глеб");
        System.out.println(myFriends.size());
        System.out.println(myFriends.set(3, "Кристина"));
        for (int i = 0; i < myFriends.size(); i++) {
            System.out.print(myFriends.get(i) + " ");
        }
        System.out.println();
        String name1 = myFriends.remove(4);
        for (int i = 0; i < myFriends.size(); i++) {
            System.out.print(myFriends.get(i) + " ");
        }
        System.out.println();
        System.out.println(myFriends.size());
        System.out.println(name1);
        System.out.println(myFriends.contains("Глеб"));
        System.out.println(myFriends.indexOf("Саша"));
        String name2 = myFriends.remove("Катя");
        System.out.println(name2);
        System.out.println(myFriends.size());
        String[] copyList = myFriends.toArray();
        for (String s : copyList) {
            System.out.print(s + " ");
        }
        System.out.println();
        StringList myColleagues = new StringListImpl();
        System.out.println(myColleagues.isEmpty());
        System.out.println(myColleagues.lastIndexOf("Георгий"));
        System.out.println(myFriends.equals(myColleagues));
        myFriends.clear();
        myFriends.add("Димон");
        myColleagues.add("Димон");
        System.out.println(myFriends.equals(myColleagues));
    }
}
