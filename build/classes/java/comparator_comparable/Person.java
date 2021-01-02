package comparator_comparable;

class Person implements Comparable<Person> {
    String name;
    int age;

    public Person(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    //사람의 정렬 기준은 나이
    @Override
    public int compareTo(Person o) {
        return this.age-o.age;
    }
}