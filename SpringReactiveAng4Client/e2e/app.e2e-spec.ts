import { SpringReactiveAng4ClientPage } from './app.po';

describe('spring-reactive-ang4-client App', () => {
  let page: SpringReactiveAng4ClientPage;

  beforeEach(() => {
    page = new SpringReactiveAng4ClientPage();
  });

  it('should display welcome message', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('Welcome to app!!');
  });
});
