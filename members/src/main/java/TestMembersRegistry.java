import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class TestMembersRegistry {
    public static void main(String[] args) throws IOException {
        MemberRegistry registry=new MemberRegistry();
        final Path path = Path.of("src/main/java/customer/members.txt");
        System.out.println(" Number fo lines "+ Files.lines(path).count());

        Files.lines(path).forEach(System.out::print);

        try (Stream<String> lines = Files.lines(path)) {
            System.out.println("count "+ lines.skip(2).limit(5).distinct().count());
            // lines.skip(2).limit(5).filter(p->p.length() > 5).distinct().forEach(System.out::print);
            //lines.filter(p -> p.length() > 5).skip(2).limit(5).distinct().forEach(System.out::print);
            // System.out.println("count "+ lines.skip(2).limit(5).distinct().count());
        } catch (final FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
/** List of members */
class MemberRegistry{
    private List<Member> members;
    public MemberRegistry(){
        members=new ArrayList<>();
    }
    public void add(Member c) {
        if (c != null)
            members.add(c);
        else
            throw new NullPointerException();
    }
    public String getPNumber(String input) {
        return members.stream().filter(p->p.getPNumber().trim().equalsIgnoreCase(input)).toString();
    }
    public Member getCustomer(String pNumber){
        //return members.stream().filter(p->p.getPNumber().trim().equalsIgnoreCase(pNumber)).map(Member);
        for (var c: members) {
            if (c.getPNumber().equalsIgnoreCase(pNumber) || c.getName().trim().equalsIgnoreCase(pNumber))
                return new Member(c.getPNumber(), c.getName(), c.getRDate());
        }
        return null;

    }
    /** get member name if match */
    public String getName(String input) {
        return members.stream().filter(p->p.getName().trim().equalsIgnoreCase(input)).toString();
    }
    /** get registration date through personal number */
    public LocalDate getRDate(String input) {
        //return members.stream().filter(p->p.getPNumber().trim().equalsIgnoreCase(input)).map(p->p.getRDate());
        for (var m : members) {
            if (m.getPNumber().equalsIgnoreCase(input) || m.getName().trim().equalsIgnoreCase(input))
                return m.getRDate();
        }
        return null;
    }
    public boolean find(String input) {
        // return members.stream().map(p -> p.getPNumber()).anyMatch(id ->
        // id.equals(pId));
        boolean isfound = false;
        for (var m : members) {
            if (m.getPNumber().equalsIgnoreCase(input) || m.getName().trim().equalsIgnoreCase(input))
                isfound=true;
        }
        return isfound;

    }
    public void delete(Member c) {
        if (c != null)
            members.remove(c);
    }
    public List<Member> getMembers() {
        return members;
    }
}
/* Member class */
final class  Member{
    private String name;
    private String pNumber;
    private LocalDate rDate;

    public Member(String pNumber,String name, LocalDate rDate)
    {
        this.pNumber=pNumber;
        this.name=name;
        this.rDate=rDate;
    }
    public String getName(){return name;}
    public String getPNumber(){return pNumber;}
    public LocalDate getRDate(){return rDate;}
}