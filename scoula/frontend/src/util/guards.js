import { useAuthStore } from '@/stores/auth';

export const isAuthenticated = (to, from) => {
  // to -> 목적지, from -> 현재 페이지
  const auth = useAuthStore();

  if (!auth.isLogin) {
    console.log('로그인 필요');
    return { name: 'login', query: { next: to.name } }; // 라우트 객체 리턴
  }

  // 아무것도 리턴 안 하면 인증된 상태
  console.log('로그인 인증');
};
