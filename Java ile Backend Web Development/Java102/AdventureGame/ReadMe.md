Macera Oyunu


Java ile metin tabanlı bir macera oyunu yapıyoruz.



KARAKTERLER

![](https://i.hizliresim.com/4jjezvb.PNG)

CANAVARLAR

![](https://i.hizliresim.com/7u79wvy.PNG)

SİLAHLAR

![](https://i.hizliresim.com/5g1r1im.PNG)

ZIRHLAR

![](https://i.hizliresim.com/hc96zz5.PNG)

MEKANLAR



Güvenli Ev


Özellik : Can Yenileniyor


Mağara


Canavar : Zombi (1-3 Adet)


Özellik : Savaş + Ganimet


Eşya : Yemek (Food)


Orman


Canavar : Vampir (1-3 Adet)


Özellik : Savaş + Ganimet


Eşya : Odun (Firewood)


Nehir


Canavar : Ayı (1-3 Adet)


Özellik : Savaş + Ganimet


Eşya : Su (Water)


Mağaza
Özellik : Destekleyici Eşyalar Satın Almak


Sınıf Diyagramı
![](https://raw.githubusercontent.com/Kodluyoruz/taskforce/main/java102/advgame-1/figures/class-diagram.jpg)

1 - Oyunu bitirebilmek için savaş bölgelerindeki tüm düşmanlar temizlendikten sonra bölgeye özel ödülü oyunucun envanterine eklenmelidir. Eğer oyuncu tüm ödülleri toplayıp "Güvenli Eve" dönebilirse oyunu kazanır. Ayrıca ödül kazanılan bölgeye tekrar giriş yapılamaz.



Bölge Ödülleri :



* Mağara => Yemek (Food)


* Orman => Odun (Firewood)


* Nehir => Su (Water)


2 - Oyuncu bir canavarla karşılaştığında ilk hamleyi kimin yapacağını, %50 şans ile belirlenmesi. (Şuan ki durumda ilk vuran her zaman oyuncu)



3 - Yeni bir savaş bölgesi eklenmeli. Bu bölgenin amacı yenilen rakiplerden rastgele para, silah veya zırh kazanma ihtimali olması.



* Bölge Adı : Maden


* Canavar : Yılan (1-5 Adet)


* Özellik : Savaş ve Ganimet


* Eşya : Para, Silah veya Zırh


Yılan Özellikleri :



* ID : 4


* HASAR : Rastgele (3 ve 6 arası)


* SAĞLIK :12


* PARA : Yok (Onun yerine eşya kazanma ihtimali)


Yenilen bir rakiplerden düşen eşyalar :



* Silah Kazanma İhtimali : 15%


* Tüfek Kazanma İhtimali : 20%


* Kılıç Kazanma İhtimali : 30%


* Tabanca Kazanma İhtimali : 50%


* Zırh Kazanma İhtimali : 15%


* Ağır Zırh Kazanma İhtimali : 20%


* Orta Zırh Kazanma İhtimali : 30%


* Hafif Zırh Kazanma İhtimali : 50%


* Para Kazanma İhtimali : 25%


* 10 Para Kazanma İhtimali: 20%


* 5 Para Kazanma İhtimali: 30%


* 1 Para Kazanma İhtimali: 50%


* Hiç birşey kazanamama ihtimali : 45%

