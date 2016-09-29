package adressbookmain;

public class AdressBookMain extends javax.swing.JPanel {
    private static javax.swing.JTable jTable;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private static int rowCnt= 0;
    private static int selectedRow;
    
    public AdressBookMain(){
        jTable = new javax.swing.JTable(new AbstractTable());
     //table size   
    javax.swing.table.TableColumn column = null;
    for(int i = 0; i < 4; i++) {
 column = jTable.getColumnModel().getColumn(i);
 if (i == 0) {
 column.setPreferredWidth(100);
 } else if(i == 1) {
 column.setPreferredWidth(150);
 } else if(i == 3) {
 column.setPreferredWidth(100);
 } else {
 column.setPreferredWidth(10);
       
        
        
        
    }}
    jScrollPane = new javax.swing.JScrollPane(jTable);
 
jPanel1 = new javax.swing.JPanel(new java.awt.BorderLayout());
 
jPanel1.add(jScrollPane, java.awt.BorderLayout.CENTER);
 
jButton1 = new javax.swing.JButton("Ekle");
 jButton2 = new javax.swing.JButton("Güncelle");
 jButton3 = new javax.swing.JButton("Sil");
 jButton4 = new javax.swing.JButton("Kapat");
 
jPanel2 = new javax.swing.JPanel(new java.awt.FlowLayout());
 
jPanel2.add(jButton1);
 jPanel2.add(jButton2);
 jPanel2.add(jButton3);
 jPanel2.add(jButton4);
 
jButton1.addActionListener(new java.awt.event.ActionListener() {
 public void actionPerformed(java.awt.event.ActionEvent e) {
 new AddEntry().setVisible(true);
 }});
jButton2.addActionListener(new java.awt.event.ActionListener() {
 public void actionPerformed(java.awt.event.ActionEvent e) {
 new UpdateEntry(jTable.getValueAt(getSelectedRow(), 0).toString(),
 jTable.getValueAt(getSelectedRow(), 1).toString(),
 jTable.getValueAt(getSelectedRow(), 2).toString(),
 jTable.getValueAt(getSelectedRow(), 3).toString()).setVisible(true);
 }
 });
 
jButton3.addActionListener(new java.awt.event.ActionListener() {
 public void actionPerformed(java.awt.event.ActionEvent e) {
 removeEntry();
 }
 });
 
jButton4.addActionListener(new java.awt.event.ActionListener() {
 public void actionPerformed(java.awt.event.ActionEvent e) {
 setVisible(true);
 System.exit(0);
 }
 });
 
jPanel1.add(jPanel2, java.awt.BorderLayout.SOUTH);
 jPanel1.setPreferredSize(new java.awt.Dimension(750, 300));
 
add(jPanel1);
 }
 
public static void addEntry(AdressBook addressBook) {
 jTable.setValueAt(addressBook.getName(), rowCnt, 0);
 jTable.setValueAt(addressBook.getAddress(), rowCnt, 1);
 jTable.setValueAt(addressBook.getTelNo(), rowCnt, 2);
 jTable.setValueAt(addressBook.getEmail(), rowCnt, 3);
 
rowCnt++;
 }
 
public static void editEntry(AdressBook addressBook) {
 jTable.setValueAt(addressBook.getName(), getSelectedRow(), 0);
 jTable.setValueAt(addressBook.getAddress(), getSelectedRow(), 1);
 jTable.setValueAt(addressBook.getTelNo(), getSelectedRow(), 2);
 jTable.setValueAt(addressBook.getEmail(), getSelectedRow(), 3);
 }
 
public void removeEntry() {
 for(int i = getSelectedRow(); i < rowCnt; i++) {
 jTable.setValueAt(jTable.getValueAt(i + 1, 0), i, 0);
 jTable.setValueAt(jTable.getValueAt(i + 1, 1), i, 1);
 jTable.setValueAt(jTable.getValueAt(i + 1, 2), i, 2);
 jTable.setValueAt(jTable.getValueAt(i + 1, 3), i, 3);
 }
 rowCnt--;
 }
 
public static int getSelectedRow() {
 jTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
 
javax.swing.ListSelectionModel rowSel = jTable.getSelectionModel();
 rowSel.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
 public void valueChanged(javax.swing.event.ListSelectionEvent e) {
 if (e.getValueIsAdjusting()) return;
 
javax.swing.ListSelectionModel sel = (javax.swing.ListSelectionModel)e.getSource();
 if (!sel.isSelectionEmpty()) {
 selectedRow = sel.getMinSelectionIndex();
 }
 }
 });
 
return selectedRow;
 }
 
class AbstractTable extends javax.swing.table.AbstractTableModel {
 private String[] columnNames = { "İsim-Soyisim", "Adres", "Tel No.", "Email" };
 private Object[][] data = new Object[100][5];
 
public int getColumnCount() {
 return columnNames.length;
 }
 
public int getRowCount() {
 return data.length;
 }
 
public String getColumnName(int col) {
 return columnNames[col];
 }
 
public Object getValueAt(int row, int col) {
 return data[row][col];
 }
 
public void setValueAt(Object value, int row, int col) {
 data[row][col] = value;
 fireTableCellUpdated(row, col);
 }
 }
 
public static void main(String args[]) {
 javax.swing.JFrame.setDefaultLookAndFeelDecorated(true);
 
javax.swing.JFrame jFrame = new javax.swing.JFrame("Adres Defteri");
 
jFrame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
 
jFrame.setResizable(false);
 
jFrame.getContentPane().add(new AdressBookMain());
 
jFrame.pack();
 jFrame.setVisible(true);
    
    
    }}
    

    
    
    

