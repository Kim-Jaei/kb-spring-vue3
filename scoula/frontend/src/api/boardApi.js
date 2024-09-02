import api from '@/api'; // 인터셉터 적용된 axios

const BASE_URL = '/api/board';
const headers = { 'Content-Type': 'multipart/form-data' };

export default {
  async getList(params) {
    // params: /api/board?page=10&amount10
    const { data } = await api.get(BASE_URL, { params });
    console.log('BOARD GET LIST: ', data); // data: 날짜 확인 파트
    return data;
  },

  async create(article) {
    const formData = new FormData();
    formData.append('title', article.title);
    formData.append('writer', article.writer);
    formData.append('content', article.content);

    if (article.files) {
      for (let i = 0; i < article.files.length; i++) {
        formData.append('files', article.files[i]);
      }
    }

    const { data } = await api.post(BASE_URL, formData, { headers });
    console.log('BOARD POST: ', data);
    return data;
  },

  async get(no) {
    const { data } = await api.get(`${BASE_URL}/${no}`);
    console.log('BOARD GET', data);
    return data;
  },

  // 게시글 삭제
  async delete(no) {
    const { data } = await api.delete(`${BASE_URL}/${no}`);
    console.log('BOARD DELETE: ', data);
    return data;
  },

  // 게시글 수정
  async update(article) {
    const formData = new FormData();
    formData.append('no', article.no);
    formData.append('title', article.title);
    formData.append('writer', article.writer);
    formData.append('content', article.content);

    if (article.files) {
      for (let i = 0; i < article.files.length; i++) {
        formData.append('files', article.files[i]);
      }
    }

    const { data } = await api.put(BASE_URL, formData, { headers });
    console.log('BOARD POST: ', data);
    return data;
  },

  // 첨부파일 삭제
  async deleteAttachment(no) {
    const { data } = await api.delete(`${BASE_URL}/deleteAttachment/${no}`);
    console.log('ATTACHMENT DELETE: ', data);
    return data;
  },
};
