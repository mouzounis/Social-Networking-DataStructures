import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.lang.Math;

public class Names {
    int randFirstName;
    int randLastName;
    private String fName;
    private String lName;
    private String randC;
    private static String[] combinedMaleNames = {"Achilles", "Adonis", "Agapetos", "Alekos", "Alexandros", "Anastasios", "Andreas", "Anthimos", "Aristides", "Christos", "Damianos", "Demetrios", "Dionysios", "Efstathios", "Evangelos", "Filippos", "Georgios", "Giannis", "Giorgos", "Grigorios", "Hercules", "Ioannis", "Iordanis", "Ippokratis", "Konstantinos", "Kyriakos", "Lefteris", "Leonidas", "Lykourgos", "Manolis", "Markos", "Marios", "Michalis", "Miltiadis", "Nikolaos", "Nikos", "Odysseas", "Panagiotis", "Paraskevas", "Pavlos", "Petros", "Polychronis", "Sotirios", "Spyridon", "Stamatis", "Stefanos", "Stylianos", "Takis", "Thanos", "Themistoklis", "Theodoros", "Timotheos", "Vasilis", "Xenophon", "Yiannis", "Zacharias", "Adrianos", "Alkibiades", "Amfilochios", "Antonios", "Artemios", "Athanasios", "Chrysostomos", "Christoforos", "Dimitrios", "Elektra", "Epaminondas", "Erasmos", "Eros", "Euthymios", "Fotis", "Haralambos", "Iakovos", "Iosif", "Kimon", "Kosmas", "Kyprianos", "Lazaros", "Milos", "Nektarios", "Nikiforos", "Orestis", "Panteleimon", "Periklis", "Philotheos", "Prodromos", "Prokopios", "Rigas", "Savvas", "Serafeim", "Sotiris", "Tasos", "Titos", "Triantafyllos", "Zisis", "Agron", "Arben", "Ardian", "Arjan", "Artan", "Astrit", "Bardhyl", "Besim", "Besnik", "Dardan", "Dritan", "Edmond", "Edi", "Elton", "Erion", "Ermal", "Fatjon", "Fatos", "Gani", "Genti", "Gjin", "Gramoz", "Ilir", "Ismail", "Klodian", "Kristian", "Luan", "Lulzim", "Mentor", "Meriton", "Nazif", "Nikollë", "Olsi", "Orion", "Petrit", "Qazim", "Raimond", "Rilind", "Sadik", "Saimir", "Shkëlqim", "Skënder", "Sokol", "Tahir", "Taulant", "Tefik", "Thoma", "Toni", "Valon", "Vasil", "Visar", "Xhemal", "Ylli", "Zef", "Altin", "Ardian", "Arlind", "Artur", "Avni", "Bashkim", "Bledar", "Burim", "Dashamir", "Dionis", "Dren", "Erald", "Eris", "Fabi", "Fation", "Festim", "Flamur", "Gëzim", "Idriz", "Iljaz", "Jasir", "Jetmir", "Kastriot", "Lindor", "Lorik", "Maliq", "Mirjan", "Ndriçim", "Nertil", "Nexhat", "Orges", "Pavli", "Plarent", "Qendrim", "Redi", "Renato", "Selim", "Tani", "Tristan", "Veton", "Xhevdet", "Zamir", "Zija"};
    private static String[] combinedFemaleNames = {"Agape", "Alexandra", "Amalia", "Anastasia", "Andriana", "Antigone", "Ariadne", "Calliope", "Chloe", "Christina", "Dafni", "Dimitra", "Dorothea", "Eirini", "Electra", "Elena", "Eleni", "Evangelia", "Georgia", "Ioanna", "Irene", "Kalliope", "Katerina", "Kleio", "Korinna", "Leda", "Maria", "Marina", "Melina", "Melpomene", "Nefeli", "Nikoleta", "Olga", "Olympia", "Panagiota", "Paraskevi", "Penelope", "Phoebe", "Rhea", "Sofia", "Sophia", "Stefania", "Thaleia", "Theodora", "Vasiliki", "Xenia", "Zoe", "Aikaterini", "Aphrodite", "Areti", "Aspasia", "Athina", "Calypso", "Chrysoula", "Danae", "Despoina", "Ekaterini", "Elpida", "Eugenia", "Filippa", "Fotini", "Helena", "Ifigeneia", "Io", "Ismini", "Kyriaki", "Loukia", "Makrina", "Nefeli", "Ourania", "Pelagia", "Polyxeni", "Roxani", "Semeli", "Sotiria", "Thekla", "Theoni", "Venetia", "Vivi", "Zinovia", "Ada", "Adelina", "Afërdita", "Aida", "Albana", "Ardita", "Aurora", "Blerina", "Diana", "Drita", "Edona", "Elira", "Elona", "Elsa", "Emira", "Enkeleida", "Era", "Erika", "Fabiola", "Fatmira", "Flutura", "Gentiana", "Gloria", "Hana", "Iliriana", "Ina", "Jonida", "Kaltrina", "Lira", "Luiza", "Marta", "Marigona", "Marsida", "Mimoza", "Miranda", "Nertila", "Rita", "Rozana", "Silvana", "Suela", "Teuta", "Valbona", "Vjollca", "Yllka", "Zamira", "Anisa", "Ariana", "Arlinda", "Besa", "Brikena", "Dafina", "Desara", "Donika", "Dorina", "Edlira", "Fjona", "Gjina", "Jona", "Kaltrina", "Klaudia", "Loreta", "Mersiana", "Nora", "Ornela", "Rea", "Sara", "Tina", "Viola", "Xhesika", "Zana", "Zhuliana"};
    private static String[] combinedMaleLastNames = {"Andreadis", "Apostolopoulos", "Argyros", "Chrysopoulos", "Dimitriadis", "Economou", "Evangelou", "Fotiadis", "Georgiou", "Giannakopoulos", "Hatzis", "Ioannidis", "Katsaros", "Kokkinos", "Konstantinou", "Koufos", "Lazaridis", "Leventis", "Makris", "Michalopoulos", "Nikolaidis", "Pappas", "Papadakis", "Papadopoulos", "Petrou", "Psaras", "Raptis", "Samaras", "Sarris", "Sotirios", "Spanos", "Stathopoulos", "Theodorou", "Tsakalos", "Vasilakis", "Xenidis", "Zafeiriou", "Agelopoulos", "Alexopoulos", "Andriopoulos", "Christodoulou", "Damaskinos", "Deligiannis", "Doukas", "Efstratiou", "Filippou", "Galani", "Giannopoulos", "Hatzigeorgiou", "Kalaitzis", "Karagiannis", "Kastrinakis", "Katsanis", "Kefalas", "Koliopoulos", "Kontogiannis", "Koronis", "Lambros", "Lykos", "Maniatis", "Metaxas", "Mitsotakis", "Nikolopoulos", "Papagiannis", "Petridis", "Sotirakopoulos", "Tsiolis", "Vlachos", "Xanthopoulos", "Zervos", "Ahmetaj", "Aliu", "Avdyli", "Bajraktari", "Beqiri", "Berisha", "Biba", "Cani", "Demaj", "Dervishi", "Dida", "Dumani", "Emini", "Fejzaj", "Gashi", "Haxhiu", "Hoxha", "Idrizi", "Islami", "Kastrati", "Kola", "Kryeziu", "Kurti", "Lika", "Lleshi", "Lusha", "Matoshi", "Meca", "Mema", "Merko", "Meta", "Miftari", "Muça", "Ndreu", "Nika", "Nikolla", "Osmani", "Peci", "Plaku", "Rama", "Rexha", "Rrahmani", "Shala", "Shehu", "Sopi", "Spahiu", "Tafa", "Toska", "Ukaj", "Veseli", "Vrapi", "Xhaferi", "Zeneli", "Zogaj"};
    private static String[] combinedFemaleLastNames = {"Andreadou", "Apostolopoulou", "Argyrou", "Chrysopoulou", "Dimitriadou", "Economou", "Evangelou", "Fotiadou", "Georgiou", "Giannakopoulou", "Hatzis", "Ioannidou", "Katsarou", "Kokkinou", "Konstantinou", "Koufou", "Lazaridou", "Leventi", "Makri", "Michalopoulou", "Nikolaidou", "Pappa", "Papadaki", "Papadopoulou", "Petrou", "Psara", "Rapti", "Samara", "Sarri", "Sotiriou", "Spanou", "Stathopoulou", "Theodorou", "Tsakalou", "Vasilaki", "Xenidou", "Zafeiriou", "Agelopoulou", "Alexopoulou", "Andriopoulou", "Christodoulou", "Damaskinou", "Deligianni", "Douka", "Efstratiou", "Filippou", "Galani", "Giannopoulou", "Hatzigeorgiou", "Kalaitzi", "Karagianni", "Kastrinaki", "Katsani", "Kefalou", "Koliopoulou", "Kontogianni", "Koroni", "Lambrou", "Lykou", "Maniati", "Metaxa", "Mitsotaki", "Nikolopoulou", "Papagianni", "Petridi", "Sotirakopoulou", "Tsioli", "Vlachou", "Xanthopoulou", "Zervou", "Ahmetaj", "Aliu", "Avdylaj", "Bajraktari", "Beqiri", "Berisha", "Biba", "Cani", "Demaj", "Dervishi", "Dida", "Dumani", "Emini", "Fejzaj", "Gashi", "Haxhiu", "Hoxha", "Idrizi", "Islami", "Kastrati", "Kola", "Kryeziu", "Kurti", "Lika", "Lleshi", "Lusha", "Matoshi", "Meca", "Mema", "Merko", "Meta", "Miftari", "Muça", "Ndreu", "Nika", "Nikolla", "Osmani", "Peci", "Plaku", "Rama", "Rexha", "Rrahmani", "Shala", "Shehu", "Sopi", "Spahiu", "Tafa", "Toska", "Ukaj", "Veseli", "Vrapi", "Xhaferi", "Zeneli", "Zogaj"};
    private static String[]city = {"Athens", "Thessaloniki", "Patra", "Heraklion", "Larissa", "Volos", "Ioannina", "Kavala", "Kalamata", "Chania", "Rhodes", "Corfu", "Agrinio", "Lamia", "Komotini", "Alexandroupoli", "Chalkida", "Serres", "Veria", "Pyrgos", "Sparta", "Drama", "Trikala", "Karditsa", "Kozani", "Florina", "Edessa", "Nafplio", "Katerini", "Rethymno", "Mytilene", "Tripoli", "Preveza", "Orestiada", "Grevena", "Thiva", "Naxos", "Zakynthos", "Lefkada", "Mykonos", "Paros", "Samos", "Chios", "Milos", "Skiathos", "Syros", "Kalymnos", "Leros", "Karpathos", "Kos", "Andros", "Tinos", "Hydra", "Spetses", "Poros", "Kea", "Aegina", "Salamis", "Kythira", "Kastoria", "Kilkis", "Arta", "Messolonghi", "Amfissa", "Farsala", "Elassona", "Naousa", "Amorgos", "Karystos", "Eretria", "Kymi", "Almyros", "Loutraki", "Galaxidi", "Epidaurus", "Antikyra", "Livadeia", "Plaka", "Karyes", "Skopelos", "Agios Nikolaos", "Ierapetra", "Neapoli", "Kranidi", "Methana", "Gytheio", "Areopoli", "Monemvasia", "Leonidio", "Ermioni", "Porto Heli", "Molyvos", "Agia Pelagia", "Arkoudi", "Kalavryta", "Dimitsana", "Stemnitsa", "Parga", "Zagori", "Metsovo"};
    private static String[] interests = {"Baking", "Birdwatching", "Meditation", "Science", "History", "Philosophy", "Anthropology", "Social Media", "Makeup", "Skincare", "Jewelry Making", "Chess", "Board Games", "Card Games", "Interior Design", "Home Improvement", "Cars", "Motorcycles", "Boating", "Climbing", "Skiing", "Snowboarding", "Ice Skating", "Surfing","Magic Tricks", "Puzzles", "Escape Rooms", "Concerts", "Music Festivals", "Theater", "Comics", "Graphic Novels", "Anime", "Manga", "Fanfiction", "DIY Projects", "Home Brewing", "Vlogging"};
    
    public static ArrayList<String> randInterestsVarSize() {
        Random rand = new Random();
        ArrayList<String> randomInterests = new ArrayList<>();
        int numberOfInterests = rand.nextInt(7) + 4;  // Random number between 4 and 10

        // Randomly select the interests
        while (randomInterests.size() < numberOfInterests) {
            String interest = interests[rand.nextInt(interests.length)];
            if (!randomInterests.contains(interest)) {  // Ensure no duplicates
                randomInterests.add(interest);
            }
        }

        return randomInterests;
    }

    public static ArrayList<String> randInterestsFixedSize() {
        Random rand = new Random();
        ArrayList<String> randomInterests = new ArrayList<>();
        int numberOfInterests = 10;  // Random number between 4 and 10

        // Randomly select the interests
        while (randomInterests.size() < numberOfInterests) {
            String interest = interests[rand.nextInt(interests.length)];
            if (!randomInterests.contains(interest)) {  // Ensure no duplicates
                randomInterests.add(interest);
            }
        }

        return randomInterests;
    }
    
    public static String randFirstName(boolean gender){
        if(!gender == false){
            int rand = (int) (Math.random()* 192) + 0;
            String randName = combinedMaleNames[rand];
            return randName;
        }

        int rand = (int) (Math.random()* 151) + 0;
        String randName = combinedFemaleNames[rand];
        return randName;
    }

    public static String randLastName(boolean gender){
        if(!gender == false){
            int rand = (int) (Math.random()* 124) + 0;
            String randName = combinedMaleLastNames[rand];
            return randName;
        }

        int rand = (int) (Math.random()* 124) + 0;
        String randName = combinedFemaleLastNames[rand];
        return randName;
    }

    public static String randCity(){
        int rand = (int) (Math.random()* 100) + 0;
        String randC = city[rand];
        return randC;
    }

    public static Integer randAge(){
        Integer rand = (int) (Math.random()*(55 - 17)) + 18;
        return rand;
    }

    public static Integer randHeight(){
        Integer rand = (int) (Math.random()*(220 - 139)+ 140);
        return rand;
    }

    public static String[] getInterests(){
        return interests;
    }

    public static boolean randGender(){
        Random random = new Random();
        return random.nextBoolean();
    }
    public static void main(String[] args) { 
    }

}