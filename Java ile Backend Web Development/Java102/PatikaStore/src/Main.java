import Enums.Brands;
import Enums.Colours;
import Products.MobilePhone;
import Products.Notebook;

import java.util.*;

public class Main {
    public static List<Notebook> notebookList = new ArrayList<Notebook>();
    public static List<MobilePhone> mobilePhoneList = new ArrayList<MobilePhone>();

    public static void main(String[] args) {
        notebookList.add(new Notebook(1, "Matebook 14", 7000.0, Brands.Huawei, 512, 14.0, 16));
        notebookList.add(new Notebook(2, "V14 IGL", 3699.0, Brands.Lenovo, 1024, 14.0, 8));
        notebookList.add(new Notebook(3, "Tuf Gaming", 8199.0, Brands.Asus, 2048, 15.6, 32));

        mobilePhoneList.add(new MobilePhone(1, "GALAXY A51", 3199.0, Brands.Samsung, 128, 6.5, 6, 32, 4000, Colours.RED));
        mobilePhoneList.add(new MobilePhone(2, "iPhone 11 64 GB", 7379.0, Brands.Apple, 64, 6.1, 6, 5, 3046, Colours.WHITE));
        mobilePhoneList.add(new MobilePhone(3, " Redmi Note 10 Pro 8GB", 4012.0, Brands.Xiaomi, 128, 6.5, 12, 35, 4000, Colours.BLUE));
        showMainMenu();

    }


    private static void showMainMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("PatikaStore Ürün Yönetim Paneli !\n" +
                "1 - Notebook İşlemleri\n" +
                "2 - Cep Telefonu İşlemleri\n" +
                "3 - Marka Listele\n" +
                "0 - Çıkış Yap");
        System.out.print("Lutfen secımınızı yapınız:");
        int choice = scanner.nextInt();
        while (choice < 0 || choice > 3) {
            System.out.println("Lutfen gecerlı bır deger gırınız:");
            choice = scanner.nextInt();
        }

        switch (choice) {
            case 1:
                notebookMenu();
                break;
            case 2:
                mobilephoneMenu();
                break;
            case 3:
                brandsMenu();
                break;
            default:
                System.out.println("Gecersız Islem");
                break;
        }
    }

    private static void brandsMenu() {
        System.out.println("Markalarımız: " + "\n" + "------------------------");
        for (Brands br : Brands.values()) {
            System.out.println("- " + br);
        }
    }

    private static void coloursMenu(){
        System.out.println("Renkler: " + "\n" + "------------------------");
        for (Colours colours : Colours.values()) {
            System.out.println("- " + colours);
        }
    }

    private static void mobilephoneMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Mobilephone Işlemlerıne Hosgeldiniz! \n" +
                "1 - Mobilephoneları Goster\n" +
                "2 - Mobilephone Ekle\n" +
                "3 - Mobilephoneları Sil\n" +
                "4 - Mobilephoneları Filtrele\n" +
                "0 - Ana Menuye Gerı Don");

        int choice = scanner.nextInt();
        while (choice < 0 || choice > 4) {
            System.out.println("Lutfen gecerlı bır deger gırınız:");
            choice = scanner.nextInt();
        }
        switch (choice) {
            case 1:
                showMobilephoneList();
                break;
            case 2:
                addMobilephone();
                break;
            case 3:
                deleteMobilephone();

                break;
            case 4:
                fılterMobilephone();
                break;
            case 0:
                showMainMenu();
                break;
            default:
                System.out.println("Gecersız Islem");
                break;
        }
    }

    private static void fılterMobilephone() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Lutfen Sıralama Yontemını Secınız +\n" +
                "1 - ID gore sırala +\n" +
                "2 - Markaya gore sırala");

        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                Collections.sort(mobilePhoneList, new Comparator<MobilePhone>() {
                    @Override
                    public int compare(MobilePhone o1, MobilePhone o2) {
                        return o1.getId() - o2.getId();
                    }
                });
                for (MobilePhone mb : mobilePhoneList) {
                    System.out.println(mb.getId() + " " + mb.getProductName());
                }
                break;
            case 2:
                Collections.sort(mobilePhoneList, new Comparator<MobilePhone>() {
                    @Override
                    public int compare(MobilePhone o1, MobilePhone o2) {
                        return o1.getBrands().compareTo(o2.getBrands());
                    }
                });
                for (MobilePhone mb : mobilePhoneList) {
                    System.out.println(mb.getBrands() + " " + mb.getProductName());
                }
                break;

        }
    }

    private static void deleteMobilephone() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Lutfen silmek istediğiniz telefonun ıd'sini giriniz: ");
        int id = scan.nextInt();
        for (MobilePhone mb : mobilePhoneList) {
            if (id == mb.getId()){
                mobilePhoneList.remove(mb);
            }
        }
    }

    private static void addMobilephone() {
        brandsMenu();
        System.out.println("####################################");
        coloursMenu();
        Scanner scan = new Scanner(System.in);
        System.out.println();

        System.out.print("Telefonun markasini seciniz: ");
        Brands brands = Brands.values()[scan.nextInt()-1];

        System.out.print("Telefonun id numarasını giriniz: ");
        int id = scan.nextInt();
            for (MobilePhone mb : mobilePhoneList) {
                while (id == mb.getId()){
                    System.out.println("Lutfen uniq id giriniz: ");
                    id = scan.nextInt();
                }

            }

        scan.nextLine();
        System.out.print("Telefonun adını giriniz: ");
        String productName = scan.nextLine();

        System.out.print("Telefonun birim fiyatini giriniz: ");
        double price = scan.nextDouble();


        System.out.print("Telefonun depolama alani miktarini giriniz: ");
        int storage = scan.nextInt();

        System.out.print("Telefonun ekran boyutunu giriniz: ");
        double screen = scan.nextInt();

        System.out.print("Telefonun batarya gücünü giriniz: ");
        double battery = scan.nextDouble();


        System.out.print("Telefonun ram'ini giriniz: ");
        int ram = scan.nextInt();

        System.out.print("Telefonun cam'ini giriniz: ");
        int cam = scan.nextInt();

        System.out.print("Telefonun rengini seciniz:");
        Colours colours = Colours.values()[scan.nextInt()-1];
        mobilePhoneList.add(new MobilePhone(id, productName, price, brands, storage, screen, ram, cam, battery, colours));

        showMainMenu();
    }

    private static void showMobilephoneList() {
        System.out.println("Cep Telefonu Listesi");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("| ID | Ürün Adı                      | Fiyat     | Marka     | Hafıza    | Ekran     | RAM       | Pil       | Renk      |");
        for(MobilePhone mobilePhone : mobilePhoneList) {
            mobilePhone.print();
        }
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
    }

    public static void notebookMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Notebook Işlemlerıne Hosgeldiniz! \n" +
                "1 - Notebookları Goster\n" +
                "2 - Notebook Ekle\n" +
                "3 - Notebookları Sil\n" +
                "4 - Notebookları Filtrele\n" +
                "0 - Ana Menuye Gerı Don");

        int choice = scanner.nextInt();
        while (choice < 0 || choice > 4) {
            System.out.println("Lutfen gecerlı bır deger gırınız:");
            choice = scanner.nextInt();
        }
        switch (choice) {
            case 1:
                showNotebookList();
                break;
            case 2:
                addNotebook();
                break;
            case 3:
                deleteNotebook();
                break;
            case 4:
                fılterNotebook();
                break;
            case 0:
                showMainMenu();
                break;
            default:
                System.out.println("Gecersız Islem");
                break;
        }
    }

    private static void addNotebook() {
        brandsMenu();
        Scanner scan = new Scanner(System.in);
        System.out.println();

        System.out.print("Bilgisayarın markasini seciniz: ");
        Brands brands = Brands.values()[scan.nextInt()-1];

        System.out.print("Bilgisayarın id numarasını giriniz: ");
        int id = scan.nextInt();
        for (MobilePhone mb : mobilePhoneList) {
            while (id == mb.getId()){
                System.out.println("Lutfen uniq id giriniz: ");
                id = scan.nextInt();
            }

        }

        scan.nextLine();
        System.out.print("Bilgisayarın adını giriniz: ");
        String productName = scan.nextLine();

        System.out.print("Bilgisayarın birim fiyatini giriniz: ");
        double price = scan.nextDouble();


        System.out.print("Bilgisayarın depolama alani miktarini giriniz: ");
        int storage = scan.nextInt();

        System.out.print("Bilgisayarın ekran boyutunu giriniz: ");
        double screen = scan.nextInt();

        System.out.print("Bilgisayarın ram'ini giriniz: ");
        int ram = scan.nextInt();

        notebookList.add(new Notebook(id,productName,price,brands,storage,screen,ram));

        showMainMenu();
    }

    private static void showNotebookList() {
        System.out.println("\nNotebook Listesi");
        System.out.println("-----------------------------------------------------------------------------------------------");
        System.out.println("| ID | Ürün Adı                      | Fiyat     | Marka     | Hafıza    | Ekran     | RAM    |");
        for(Notebook noteBook : notebookList) {
            noteBook.print();
        }
        System.out.println("-----------------------------------------------------------------------------------------------");
    }


    private static void deleteNotebook() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Lutfen silmek istediğiniz bilgisayarın ıd'sini giriniz: ");
        int id = scan.nextInt();
        for (Notebook notebook : notebookList) {
            if (id == notebook.getId()){
                notebookList.remove(notebook);
            }
        }
    }

    private static void fılterNotebook() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Lutfen Sıralama Yontemını Secınız +\n" +
                "1 - ID gore sırala +\n" +
                " 2 - Markaya gore sırala");

        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                Collections.sort(notebookList, new Comparator<Notebook>() {
                    @Override
                    public int compare(Notebook o1, Notebook o2) {
                        return o1.getId() - o2.getId();
                    }
                });
                break;
            case 2:
                Collections.sort(notebookList, new Comparator<Notebook>() {
                    @Override
                    public int compare(Notebook o1, Notebook o2) {
                        return o1.getBrands().compareTo(o2.getBrands());
                    }
                });
                break;

        }
    }
}