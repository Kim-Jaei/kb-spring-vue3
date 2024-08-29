import api from '@/api'; // 인터셉트가 적용된 axios

const BASE_URL = '/api/member';
const headers = { 'Content-Type': 'multipart/form-data' }; // 인코딩 타입 설정 (안 하면 json 디폴트)

export default {
  // username 중복 체크, true: 중복(사용 불가), false: 사용 가능
  async checkUsername(username) {
    // 비동기 통신 끝날 때까지 기다리기
    const { data } = await api.get(`${BASE_URL}/checkusername/${username}`);
    console.log('AUTH GET CHECKUSERNAME', data);
    return data;
  },

  async create(member) {
    // 아바타 파일 업로드 – multipart 인코딩 필요 → FormData 객체 사용
    const formData = new FormData();
    // DTO 프로퍼티명
    formData.append('username', member.username);
    formData.append('email', member.email);
    formData.append('password', member.password);

    if (member.avatar) {
      formData.append('avatar', member.avatar); // 파일 첨부
    }

    const { data } = await api.post(`${BASE_URL}`, formData, { headers }); // formData -> body

    console.log('AUTH POST: ', data);
    return data; // MemberDTO 내용 리턴
  },

  async update(member) {
    const formData = new FormData();
    // DTO 프로퍼티명
    formData.append('username', member.username);
    formData.append('email', member.email);
    formData.append('password', member.password);

    if (member.avatar) {
      formData.append('avatar', member.avatar); // 파일 첨부
    }

    const { data } = await api.put(
      `${BASE_URL}/${member.username}`,
      formData,
      headers
    ); // formData -> body

    console.log('AUTH PUT: ', data);
    return data; // MemberDTO 내용 리턴
  },

  async changePassword(formData) {
    const { data } = await api.put(
      `${BASE_URL}/${formData.username}/changepassword`,
      formData
    );
    console.log('AUTH PUT', data); // body가 없음

    return data;
  },
};
