package access_modifiers_encapsulation.class_problems;

public class SubclassTicketAccess {
    public static String classifyAccess(String fieldModifier, String accessorContext) {
        switch (fieldModifier.toLowerCase()) {
            case "public":
                return "ALLOWED";
            case "private":
                return accessorContext.equals("SAME_CLASS") ? "ALLOWED" : "DENIED";
            case "default":
                return (accessorContext.equals("SAME_CLASS") || accessorContext.equals("SAME_PACKAGE")) ? "ALLOWED" : "DENIED";
            case "protected":
                if (accessorContext.equals("SAME_CLASS") || accessorContext.equals("SAME_PACKAGE")) {
                    return "ALLOWED";
                }
                if (accessorContext.equals("SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE")) {
                    return "ALLOWED";
                }
                // SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE and DIFFERENT_PACKAGE are DENIED
                return "DENIED";
            default:
                return "DENIED";
        }
    }

    public static void main(String[] args) {
        System.out.println(classifyAccess("protected", "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"));
        System.out.println(classifyAccess("protected", "SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE"));
    }
}