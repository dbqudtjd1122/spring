package com.bbs.commons;

public class PagingHelper {  

    private int           numberPerPage ; //페이지당 출력할 레코드 수. 기본값은 10으로 한다.
    private int           pagePerBlock  ; //페이징시 나타낼 페이지 수. 기본값은 10으로 한다.
    
    private int           totalPage;      // 총 페이지 개수
    private int           firstPage;      // 첫번째 페이지 번호
    private int           lastPage;       // 마지막 페이지 번호
    private int           prevLink;       // 이전 게시물
    private int           nextLink;       // 다음 게시물
    private int           startRecord;    // 목록을 구할때 쓰이는 ROWNUM 시작
    private int           endRecord;      // 목록을 구할때 쓰이는 ROWNUM 끝
    private int           listNo;         // 목록에서 위에서 순서대로 붙여지는 번호
    private int[]         pageLinks;      // 첫번쩨 페이지 번호부터 시작하여 1씩 증가하여 마지막 페이지번호까지의 int[] 배열
    private int           totalLastPage;
    private int           totalFirstPage;
      
    public int getFirstPage() {
        return firstPage;
    }
    
    public int getLastPage() {
        return lastPage;
    }
    
    public int getPrevLink() {
        return prevLink;
    }
    
    public int getNextLink() {
        return nextLink;
    }
    
    public int getStartRecord() {
        return startRecord;
    }
    
    public int getEndRecord() {
        return endRecord;
    }
    
    public int getListNo() {
        return listNo;
    }
    
    public int[] getPageLinks() {
        return pageLinks;
    }
    
    public int getTotalPage() {
        return totalPage;
    }
    
    public int getNumberPerPage() {
        return numberPerPage;
    }

    public void setNumberPerPage(int numberPerPage) {
        this.numberPerPage = numberPerPage;
    }

    public int getPagePerBlock() {
        return pagePerBlock;
    }

    public void setPagePerBlock(int pagePerBlock) {
        this.pagePerBlock = pagePerBlock;
    }

    public int getTotalLastPage() {
        return this.totalPage;
    }

    public int getTotalFirstPage() {
        return 1;
    }
    

    public PagingHelper() {     
        this.numberPerPage = 10;
        this.pagePerBlock  = 10; 
    }
    
    public PagingHelper(int totalRecord, int curPage) {
        super();
        
        this.numberPerPage = 10;
        this.pagePerBlock  = 10; 
        
        setPagingValue(totalRecord, curPage, this.numberPerPage, this.pagePerBlock);
    }
    
    public PagingHelper(int totalRecord, int curPage, int numberPerPage, int pagePerBlock) {
        super();
        this.numberPerPage = numberPerPage;
        this.pagePerBlock = pagePerBlock;
        
        setPagingValue(totalRecord, curPage, numberPerPage, pagePerBlock);
    }
    

    public void setPagingValue(int totalRecord, int curPage) {
    
        setPagingValue(totalRecord, curPage, this.numberPerPage, this.pagePerBlock);
    }
    
    public void setPagingValue(int totalRecord, int curPage, int numberPerPage, int pagePerBlock) {
        
        this.totalPage = ((totalRecord % numberPerPage) == 0)  
                ? totalRecord / numberPerPage : totalRecord / numberPerPage + 1;
        
        int totalBlock = ((totalPage % pagePerBlock) == 0)
                ? totalPage / pagePerBlock : totalPage / pagePerBlock + 1;
        
        int block = ((curPage % pagePerBlock) == 0) ? curPage / pagePerBlock
                : curPage / pagePerBlock + 1;
        
        this.firstPage = (block - 1) * pagePerBlock + 1;
        
        this.lastPage = block * pagePerBlock;
        
        if (block >= totalBlock) {
            this.lastPage = totalPage;
        }
        
        pageLinks = makeArray(firstPage, lastPage);
        
        if (block > 1) {
            this.prevLink = firstPage - 1;
        }
        
        if (block < totalBlock) {
            this.nextLink = lastPage + 1;
        }
        
        this.listNo = totalRecord - (curPage - 1) * numberPerPage;
        this.startRecord = (curPage - 1) * numberPerPage + 1;
        this.endRecord = startRecord + numberPerPage - 1;
    }

    private int[] makeArray(int first, int last) {
        int size = last - first + 1;
        int[] ret = new int[size];
        for (int i = 0; i < size; i++) {
            ret[i] = first++;
        }
        
        return ret;
    }
    
}
