class CompanyStructure {
        public static void main(String[] args) {
        TechnicalEmployee Doug = new TechnicalEmployee("Doug");
        System.out.println(Doug.getEmployeeID());
        TechnicalEmployee Runcorn = new TechnicalEmployee("Runcorn");
        System.out.println(Runcorn.getEmployeeID());
        System.out.println(Doug.equals(Runcorn));
        System.out.println(Doug.equals(Doug));
        System.out.println(Runcorn.toString());
        System.out.println(Runcorn.getBaseSalary());
        TechnicalLead Jeff = new TechnicalLead("Jeff");
        System.out.println(Jeff.getBaseSalary());
    }
    

















}