#Turizm Acente Sistemi

<p>
Patika Turizm Acentesi işlerini dijital ortamdan yürütebileceği bir yapıya ihtiyaç duymaktadır. Patika ile bu dijital altyapı için anlaştığınızı varsayın.

Patika Turizm Acentesinin çalışma mantığı şu şekildedir : Oteller Patika Turizm Acentesine belirli oda rezerv ederler ve bu odaları acentenin satmasını beklerler. Acente bu odaları satarken üstüne kendi hizmet bedelini yüzde veya sabit bir fiyat koyarak müşterilerine satar.

Acente bu işleri kağıt üzerinde ve manuel olarak yapmanın zaman kaybı olduğunu düşünür, işini kolaylaştıracak bir yazılıma ihtiyaç duymaktadır.

Acentenin yazılımdan beklentisi :

</p>

##Otel Yönetimi

<p>Acente anlaşmalı olduğu otelleri, konum bilgileri ve diğer özellikleri ile birlikte sistemden yönetmeli. Otel eklenirken Otel Adı, Adres, E-posta, Telefon, Yıldız, Tesis Özellikleri, Pansiyon tipleri gibi diğer tanımlamalar yapılır. </p>

###Sistemde olması beklenen Pansiyon Tipleri :
* Ultra Herşey Dahil
* Herşey Dahil
* Oda Kahvaltı
* Tam Pansiyon
* Yarım Pansiyon
* Sadece Yatak
* Alkol Hariç Full credit
###Sistemde olması beklenen Tesis Özellikleri :
* Ücretsiz Otopark
* Ücretsiz WiFi
* Yüzme Havuzu
* Fitness Center
* Hotel Concierge
* SPA
* 7/24 Oda Servisi

##Örnek Otel Verisi 

<p>
Otellere ait tarihsel dönemler eklenir ve fiyatlandırmalar bu dönemler üzerinden yapılır. Burada ki amaç değişken bir fiyatlandırma sunabilmektir. Yaz aylarında otel fiyatları daha yüksek iken, bu durum kış ayları için daha azdır. Fiyatlandırmalar turizm sektöründe dönemsel olarak yapılır. Dönemler iki tarih aralığı olarak tanımlanır.
Örnek Dönemler :

* 01/01/2021 - 31/05/2021
* 01/06/2021 - 01/12/2021

###Oda Yönetimi
Acente otellerden rezerv ettiği odaları sisteme ekler ve bu odalar üzerinden fiyatlandırma sağlar. Otellerde genellikle Single, Double, Suit vb. gibi belirli oda tipleri mevcuttur ve aynı türdeki oda tiplerini sistemde tekrar tekrar eklememek için stok mantığı kullanılmaktadır. Ayrıca odalara ait özelliklerde girilmelidir.

Sistemde olması beklenen Oda Özellikleri :
Yatak sayısı dışında ki diğer bilgileri opsiyoneldir.

* Yatak Sayısı
* Televizyon (Var, Yok)
* Minibar (Var ,Yok)
* Oyun Konsolu (Var, Yok)
* Metrekare
* Kasa
* Projeksiyon
</p>
 Örnek Oda Verisi:


Oda Fiyatlandırmaları
Odalar gecelik fiyat olarak hesaplanır. Fiyatlar otel için eklenmiş olan dönemler üzerinden pansiyon ve yetişkin çocuk tiplerine göre tanımlanır.

Sistemde olması beklenen Fiyatlandırma :
Fiyatlar odaların gecelik bedellerine göre tanımlanır. Bu fiyatlara acentenin komisyon bedeli dahildir.

Oda Arama ve Rezervasyon İşlemleri
Acente çalışanı sistem üzerinden girdiği tarih aralığına , Bölgeye veya Otellere ve misafir bilgisine göre oda arayabilmeli.

##Oda Arama Algoritması
Acente gerekli oda arama bilgileri girdikten sonra, sistemde tanımlı olan odaları listeleyebilir.

Odaların listede çıkması için :

* Odaya ait otelin istenilen bölge içinde olmalı.
* İstenilen tarih aralığına göre otelin dönem bilgisi olmalıdır.Örneğin,Giriş Tarihi : 09/06/2021 , Çıkış Tarihi : 12/06/2021 olan bir arama için, otellerin o tarih aralığında bir dönemleri olmalı.
* Eğer otele ait dönem var ise, odanın da ilgili dönemlerde pansiyon tiplerine göre fiyat bilgisi olmalıdır ki müşteriye fiyat bilgisi verilebilsin.
* Odanın stok sayısı 0'dan büyük olmalı.
<br></br>Örnek Arama Verisi
* Bölge : Beyoğlu
* Giriş Tarihi : 01/04/2021
* Çıkış Tarihi : 03/04/2021
* Misafir Bilgisi : 2 Yetişkin, 1 Çocuk
* Fiyat Hesaplama
* Fiyatlar misafir bilgisi , kalınacak gece sayısı ve pansiyon üzerinden hesaplanır.

Bu bilgilere göre

* İlk önce bölgede ki oteller bulunur.
* Bulunan otele ait stoğu olan odalar bulunur.
* Odaların ilgili tarih aralığında dönem fiyat bilgisi var ise fiyat hesaplaması yapılır.

Rezervasyon İşlemi
Acente kullanıcısı listelediği otellere ait oda tiplerinden uygun olan pansiyon tipini seçerek rezervasyonu tamamlar.

Rezervasyon tamamlamak için :

* Müşteri iletişim bilgileri
* Misafir Ad Soyad ve T.C. Kimlik Bilgileri
* girerek sistem üzerinden satışı tamamlar. Eğer satış tamamlanırsa ilgili odanın stoğu 1 azalmış olur.
