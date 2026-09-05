package access_modifiers_encapsulation.assigment_problems;

class LibraryMember {
    private String membershipPin;
    String branchCode;
    protected double finesOwed;
    public String displayName;

    public LibraryMember(String membershipPin, String branchCode, double finesOwed, String displayName) {
        this.membershipPin = membershipPin;
        this.branchCode = branchCode;
        this.finesOwed = finesOwed;
        this.displayName = displayName;
    }
}

public class MembershipFieldReachChecker {
    public static String classifyAccess(String fieldModifier, String accessorContext) {
        switch (fieldModifier.toLowerCase()) {
            case "public":
                return "ALLOWED";
            case "private":
                return accessorContext.equals("SAME_CLASS") ? "ALLOWED" : "DENIED";
            case "default":
                return (accessorContext.equals("SAME_CLASS") || accessorContext.equals("SAME_PACKAGE")) ? "ALLOWED" : "DENIED";
            case "protected":
                return (accessorContext.equals("SAME_CLASS") || accessorContext.equals("SAME_PACKAGE")) ? "ALLOWED" : "DENIED";
            default:
                return "DENIED";
        }
    }

    public static String summarizeByModifier(String[][] attempts) {
        int privAllowed = 0, privDenied = 0;
        int defAllowed = 0, defDenied = 0;
        int protAllowed = 0, protDenied = 0;
        int pubAllowed = 0, pubDenied = 0;

        for (String[] attempt : attempts) {
            String mod = attempt[0].toLowerCase();
            String context = attempt[1];
            boolean isAllowed = "ALLOWED".equals(classifyAccess(mod, context));

            switch (mod) {
                case "private":
                    if (isAllowed) privAllowed++; else privDenied++;
                    break;
                case "default":
                    if (isAllowed) defAllowed++; else defDenied++;
                    break;
                case "protected":
                    if (isAllowed) protAllowed++; else protDenied++;
                    break;
                case "public":
                    if (isAllowed) pubAllowed++; else pubDenied++;
                    break;
            }
        }

        return "private: " + privAllowed + " allowed / " + privDenied + " denied | " +
               "default: " + defAllowed + " allowed / " + defDenied + " denied | " +
               "protected: " + protAllowed + " allowed / " + protDenied + " denied | " +
               "public: " + pubAllowed + " allowed / " + pubDenied + " denied";
    }

    public static void main(String[] args) {
        System.out.println(classifyAccess("private", "SAME_CLASS"));
        System.out.println(classifyAccess("protected", "DIFFERENT_PACKAGE"));

        String[][] batch = {
            {"private", "SAME_CLASS"},
            {"private", "SAME_PACKAGE"},
            {"default", "SAME_PACKAGE"},
            {"default", "DIFFERENT_PACKAGE"},
            {"protected", "SAME_PACKAGE"},
            {"protected", "SAME_CLASS"},
            {"public", "DIFFERENT_PACKAGE"}
        };
        System.out.println(summarizeByModifier(batch));
    }
}