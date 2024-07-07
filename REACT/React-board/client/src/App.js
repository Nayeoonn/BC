import logo from './logo.svg';
import './App.css';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import Index from './pages/Index'
import ListPage from './pages/board/ListPage';
import InsertPage from './pages/board/InsertPage';
import ReadPage from './pages/board/ReadPage';
import UpdatePage from './pages/board/UpdatePage';
function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path='/' element={<Index />}></Route>
        <Route path='/boards' element={<ListPage/>}></Route>
        <Route path='/boards/insert' element={<InsertPage/>}></Route>
        <Route path='/boards/:no' element={<ReadPage/>}></Route>
        {/* :no -> 값을 전달받음 */}
        <Route path='/boards/update/:no' element={<UpdatePage/>}></Route>
      </Routes>
    </BrowserRouter>
  );
}

export default App;
