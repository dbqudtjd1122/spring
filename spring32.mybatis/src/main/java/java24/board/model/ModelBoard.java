package    java24.board.model;

import java.util.Date;

public    class    ModelBoard    {
                
           private String  boardcd     ;      //      VARCHAR(20)    NOT    NULL
           private String  boardnm     ;      //   VARCHAR(40)    NOT    NULL
           private Boolean  UseYN       ;      //      TINYINT(1)    NOT    NULL    DEFAULT    1
           private String  InsertUID   ;      //      VARCHAR(40)    NULL    DEFAULT    NULL
           private Date  InsertDT    ;      //      DATETIME    NULL    DEFAULT    NULL
           private String  UpdateUID   ;      //  VARCHAR(40)    NULL    DEFAULT    NULL
           private Date  UpdateDT    ;      //   DATETIME    NULL    DEFAULT    NULL
       
           //
           public String getBoardcd() {
            return boardcd;
        }
        public void setBoardcd(String boardcd) {
            this.boardcd = boardcd;
        }
        public String getBoardnm() {
            return boardnm;
        }
        public void setBoardnm(String boardnm) {
            this.boardnm = boardnm;
        }
        public Boolean getUseYN() {
            return UseYN;
        }
        public void setUseYN(Boolean useYN) {
            UseYN = useYN;
        }
        public String getInsertUID() {
            return InsertUID;
        }
        public void setInsertUID(String insertUID) {
            InsertUID = insertUID;
        }
        public Date getInsertDT() {
            return InsertDT;
        }
        public void setInsertDT(Date insertDT) {
            InsertDT = insertDT;
        }
        public String getUpdateUID() {
            return UpdateUID;
        }
        public void setUpdateUID(String updateUID) {
            UpdateUID = updateUID;
        }
        public Date getUpdateDT() {
            return UpdateDT;
        }
        public void setUpdateDT(Date updateDT) {
            UpdateDT = updateDT;
        }
     // toString
        @Override
        public String toString() {
            return "ModelBoard [boardcd=" + boardcd + ", boardnm=" + boardnm
                    + ", UseYN=" + UseYN + ", InsertUID=" + InsertUID
                    + ", InsertDT=" + InsertDT + ", UpdateUID=" + UpdateUID
                    + ", UpdateDT=" + UpdateDT + "]";
        }
       //
    public ModelBoard() {
        super();
    }
        
           
        
           
}
