package team.project.service;
//�̵��Ϸ��� ���� ���������� �����ϴ� Ŭ����
public class NextPage {
	//�̵��Ϸ��� ������ �̸�
	private String pageName;
	//�̵� ���
	private boolean isRedirect;
	
	
	public String getPageName() {
		return pageName;
	}
	public void setPageName(String pageName) {
		this.pageName = pageName;
	}
	public boolean isRedirect() {
		return isRedirect;
	}
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
}
