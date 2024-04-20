class Obat {
    private String nama;
    private int harga;
    private int stok;


    Obat(String nama, int harga, int stok){
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
    }

     String getNama(){
        return this.nama;
    }
    int getHarga(){
        return this.harga;
    }
     int getStok(){
        return this.stok;
    }

    void setNama(String nama){
        this.nama = nama;
    }
    void setHarga(int harga){
        this.harga = harga;
    }
    void setStok(int stok){
        this.stok = stok;
    }
}